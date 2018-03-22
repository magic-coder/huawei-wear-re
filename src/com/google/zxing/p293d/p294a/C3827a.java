package com.google.zxing.p293d.p294a;

import android.support.v4.view.InputDeviceCompat;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.zxing.p278b.C3717b;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetail;
import com.sina.weibo.sdk.constant.WBConstants;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: BitMatrixParser */
final class C3827a {
    private static final int[][] f14842a;
    private final C3717b f14843b;

    static {
        r0 = new int[33][];
        int[] iArr = new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3, iArr};
        r0[16] = new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838};
        r0[17] = new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3};
        r0[18] = new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED, HttpStatus.SC_GATEWAY_TIMEOUT, 511, 510, 517, 516, 842, 841};
        r0[19] = new int[]{489, 488, 495, 494, HttpStatus.SC_NOT_IMPLEMENTED, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, HttpStatus.SC_INSUFFICIENT_STORAGE, 506, InputDeviceCompat.SOURCE_DPAD, 512, 519, 518, 843, -3};
        r0[20] = new int[]{491, 490, 497, 496, 503, HttpStatus.SC_BAD_GATEWAY, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844};
        r0[21] = new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3};
        r0[22] = new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, SpecialIssueType.BUG_TYPE_ID_CHARGE, 537, 536, 531, 530, 525, 524, 848, 847};
        r0[23] = new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, TagName.ELECTRONIC_USE_COUNT, 118, 539, 538, 533, 532, 527, 526, 849, -3};
        r0[24] = new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, HeartRateDetail.HEART_RATE_TYPE_TRANQUILLIZATION, HeartRateDetail.HEART_RATE_TYPE_SPORT, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850};
        r0[25] = new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3};
        r0[26] = new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853};
        r0[27] = new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3};
        r0[28] = new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856};
        r0[29] = new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3};
        r0[30] = new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859};
        r0[31] = new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3};
        r0[32] = new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862};
        f14842a = r0;
    }

    C3827a(C3717b c3717b) {
        this.f14843b = c3717b;
    }

    byte[] m19093a() {
        byte[] bArr = new byte[SyslogAppender.LOG_LOCAL2];
        int e = this.f14843b.m18720e();
        int d = this.f14843b.m18719d();
        int i = 0;
        while (i < e) {
            int[] iArr = f14842a[i];
            int i2 = 0;
            while (i2 < d) {
                int i3 = iArr[i2];
                if (i3 >= 0 && this.f14843b.m18712a(i2, i)) {
                    int i4 = i3 / 6;
                    bArr[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr[i4]);
                }
                i2++;
            }
            i++;
        }
        return bArr;
    }
}
