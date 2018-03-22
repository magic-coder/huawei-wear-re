package com.huawei.crowdtestsdk.feedback.widgets.photoSelector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.huawei.crowdtestsdk.feedback.widgets.photoSelector.ImageBean.ImageSize;
import com.huawei.crowdtestsdk.feedback.widgets.photoSelector.ImageBean.ImgBeanHolder;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ImageLoader {
    private static ImageLoader mInstance;
    private Handler mHandler;
    private LruCache<String, Bitmap> mLruCache;
    private volatile Semaphore mPoolSemaphore;
    private Thread mPoolThread;
    private Handler mPoolThreadHander;
    private volatile Semaphore mSemaphore = new Semaphore(0);
    private LinkedList<Runnable> mTasks;
    private int mThreadCount = 1;
    private ExecutorService mThreadPool;
    private Type mType = Type.LIFO;

    class C07371 extends Thread {

        class C07361 extends Handler {
            C07361() {
            }

            public void handleMessage(Message message) {
                ImageLoader.this.mThreadPool.execute(ImageLoader.this.getTask());
                try {
                    ImageLoader.this.mPoolSemaphore.acquire();
                } catch (InterruptedException e) {
                }
            }
        }

        C07371() {
        }

        public void run() {
            Looper.prepare();
            ImageLoader.this.mPoolThreadHander = new C07361();
            ImageLoader.this.mSemaphore.release();
            Looper.loop();
        }
    }

    class C07393 extends Handler {
        C07393() {
        }

        public void handleMessage(Message message) {
            ImgBeanHolder imgBeanHolder = (ImgBeanHolder) message.obj;
            ImageView imageView = imgBeanHolder.getImageView();
            Bitmap bitmap = imgBeanHolder.getBitmap();
            if (imageView.getTag().toString().equals(imgBeanHolder.getPath())) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public enum Type {
        FIFO,
        LIFO
    }

    public static ImageLoader getInstance() {
        synchronized (ImageLoader.class) {
            if (mInstance == null) {
                mInstance = new ImageLoader(1, Type.LIFO);
            }
        }
        return mInstance;
    }

    private ImageLoader(int i, Type type) {
        init(i, type);
    }

    private void init(int i, Type type) {
        this.mPoolThread = new C07371();
        this.mPoolThread.start();
        this.mLruCache = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) {
            protected int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
        this.mThreadPool = Executors.newFixedThreadPool(i);
        this.mPoolSemaphore = new Semaphore(i);
        this.mTasks = new LinkedList();
        if (type == null) {
            type = Type.LIFO;
        }
        this.mType = type;
    }

    public void loadImage(final String str, final ImageView imageView) {
        imageView.setTag(str);
        if (this.mHandler == null) {
            this.mHandler = new C07393();
        }
        Bitmap bitmapFromLruCache = getBitmapFromLruCache(str);
        if (bitmapFromLruCache != null) {
            ImgBeanHolder imgBeanHolder = new ImgBeanHolder();
            imgBeanHolder.setBitmap(bitmapFromLruCache);
            imgBeanHolder.setImageView(imageView);
            imgBeanHolder.setPath(str);
            Message obtain = Message.obtain();
            obtain.obj = imgBeanHolder;
            this.mHandler.sendMessage(obtain);
            return;
        }
        addTask(new Runnable() {
            public void run() {
                Bitmap videoThumb2;
                ImageSize access$500 = ImageLoader.this.getImageViewWidth(imageView);
                int width = access$500.getWidth();
                int height = access$500.getHeight();
                if (str.endsWith("mp4")) {
                    videoThumb2 = ImageLoader.getVideoThumb2(str);
                } else {
                    videoThumb2 = ImageLoader.this.decodeSampledBitmapFromResource(str, width, height);
                }
                ImageLoader.this.addBitmapToLruCache(str, videoThumb2);
                ImgBeanHolder imgBeanHolder = new ImgBeanHolder();
                imgBeanHolder.setBitmap(ImageLoader.this.getBitmapFromLruCache(str));
                imgBeanHolder.setImageView(imageView);
                imgBeanHolder.setPath(str);
                Message obtain = Message.obtain();
                obtain.obj = imgBeanHolder;
                ImageLoader.this.mHandler.sendMessage(obtain);
                ImageLoader.this.mPoolSemaphore.release();
            }
        });
    }

    public static Bitmap getVideoThumb2(String str) {
        return getVideoThumb2(str, 3);
    }

    public static Bitmap getVideoThumb2(String str, int i) {
        return ThumbnailUtils.createVideoThumbnail(str, i);
    }

    private synchronized void addTask(Runnable runnable) {
        try {
            if (this.mPoolThreadHander == null) {
                this.mSemaphore.acquire();
            }
        } catch (InterruptedException e) {
        }
        this.mTasks.add(runnable);
        this.mPoolThreadHander.sendEmptyMessage(272);
    }

    private synchronized Runnable getTask() {
        Runnable runnable;
        if (this.mType == Type.FIFO) {
            runnable = (Runnable) this.mTasks.removeFirst();
        } else if (this.mType == Type.LIFO) {
            runnable = (Runnable) this.mTasks.removeLast();
        } else {
            runnable = null;
        }
        return runnable;
    }

    public static ImageLoader getInstance(int i, Type type) {
        synchronized (ImageLoader.class) {
            if (mInstance == null) {
                mInstance = new ImageLoader(i, type);
            }
        }
        return mInstance;
    }

    private ImageSize getImageViewWidth(ImageView imageView) {
        int i;
        int i2 = 0;
        ImageSize imageSize = new ImageSize();
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams.width == -2) {
            i = 0;
        } else {
            i = imageView.getWidth();
        }
        if (i <= 0) {
            i = layoutParams.width;
        }
        if (i <= 0) {
            i = getImageViewFieldValue(imageView, "mMaxWidth");
        }
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        if (layoutParams.height != -2) {
            i2 = imageView.getHeight();
        }
        if (i2 <= 0) {
            i2 = layoutParams.height;
        }
        if (i2 <= 0) {
            i2 = getImageViewFieldValue(imageView, "mMaxHeight");
        }
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        imageSize.setWidth(i);
        imageSize.setHeight(i2);
        return imageSize;
    }

    private Bitmap getBitmapFromLruCache(String str) {
        return (Bitmap) this.mLruCache.get(str);
    }

    private void addBitmapToLruCache(String str, Bitmap bitmap) {
        if (getBitmapFromLruCache(str) == null && bitmap != null) {
            this.mLruCache.put(str, bitmap);
        }
    }

    private int calculateInSampleSize(Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 <= i || i4 <= i2) {
            return 1;
        }
        return Math.max(Math.round(((float) i3) / ((float) i)), Math.round(((float) i3) / ((float) i)));
    }

    private Bitmap decodeSampledBitmapFromResource(String str, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private static int getImageViewFieldValue(Object obj, String str) {
        int intValue;
        Object e;
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            try {
                Log.e("TAG", intValue + "");
                return intValue;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            intValue = 0;
            e = exception;
            Log.i("BETACLUB_SDK", "[ImageLoader.getImageViewFieldValue]Exception:" + e);
            return intValue;
        }
    }
}
