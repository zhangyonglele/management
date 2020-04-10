package com.lib.management.service;

import com.lib.management.model.LibrarianBroadcast;


public interface LibrarianBroadcastService {
    boolean addNewBroadcast(LibrarianBroadcast broadcast);

    boolean updateBroadcast(LibrarianBroadcast broadcast);
}
