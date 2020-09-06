package com.khobre.karayek.util.communication;


import com.khobre.karayek.util.IabResult;

public interface BillingSupportCommunication {
    void onBillingSupportResult(int response);
    void remoteExceptionHappened(IabResult result);
}
