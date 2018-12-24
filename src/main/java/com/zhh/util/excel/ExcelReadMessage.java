package com.zhh.util.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhh.yin
 * @version v.1.0.0
 * @description This's class Record excel read results, including error messages
 * @date 2018/12/22 17:41
 */
public class ExcelReadMessage {

    /*错误信息*/
    private List<String> readMessages = new ArrayList<>();

    /*是否存在错误*/
    private boolean readOk = true;

    public List<String> getReadMessages() {
        return readMessages;
    }

    public void setReadMessages(List<String> readMessages) {
        this.readMessages = readMessages;
    }

    public void addReadMessages(List<String> readMessage) {
        readMessages.addAll(readMessage);
    }

    public boolean isReadOk() {
        return readOk;
    }

    public void setReadOk(boolean readOk) {
        this.readOk = readOk;
    }

    public void addMessage(String msg) {
        readMessages.add(msg);
    }

    /**
     * 清空状态
     */
    public void clear() {
        readOk = true;
        readMessages.clear();
    }

    /**
     * 添加读取状态
     *
     * @param status 读取信息
     */
    public void mergeReadStatus(ExcelReadMessage status) {
        if (status == null) {
            return;
        }
        if (!status.isReadOk()) {
            readOk = false;
        }
        addReadMessages(status.getReadMessages());
    }
}
