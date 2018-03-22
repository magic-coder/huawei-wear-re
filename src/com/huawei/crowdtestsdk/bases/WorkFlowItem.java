package com.huawei.crowdtestsdk.bases;

public class WorkFlowItem {
    private String internalRemark;
    private String processDefinitionId;
    private String processDefinitionKey;
    private String processInstanceId;
    private String sequenceFlow;
    private String taskId;
    private String workflowToken;

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public String getSequenceFlow() {
        return this.sequenceFlow;
    }

    public void setSequenceFlow(String str) {
        this.sequenceFlow = str;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String str) {
        this.processInstanceId = str;
    }

    public String getProcessDefinitionKey() {
        return this.processDefinitionKey;
    }

    public void setProcessDefinitionKey(String str) {
        this.processDefinitionKey = str;
    }

    public String getProcessDefinitionId() {
        return this.processDefinitionId;
    }

    public void setProcessDefinitionId(String str) {
        this.processDefinitionId = str;
    }

    public String getInternalRemark() {
        return this.internalRemark;
    }

    public void setInternalRemark(String str) {
        this.internalRemark = str;
    }

    public String getWorkflowToken() {
        return this.workflowToken;
    }

    public void setWorkflowToken(String str) {
        this.workflowToken = str;
    }
}
