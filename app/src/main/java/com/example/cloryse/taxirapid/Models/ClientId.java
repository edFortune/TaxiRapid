package com.example.cloryse.taxirapid.Models;

import android.support.annotation.NonNull;

public class ClientId {

    public String clientId;

    public <T extends  ClientId> T withId(@NonNull final String id){
        this.clientId = id;
        return (T) this;
    }

}
