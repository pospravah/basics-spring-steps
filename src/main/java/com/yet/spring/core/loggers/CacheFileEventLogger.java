package com.yet.spring.core.loggers;
import com.yet.spring.core.beans.Event;

import java.io.IOException;
import java.util.ArrayList;

public class CacheFileEventLogger extends FileEventLogger {

    int cacheSize;
    ArrayList<Event> cache = new ArrayList<Event>();


    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }


    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() <= cacheSize) {
            writeEventsFromCache(cache);
            cache.clear();
        }
   }

    private void writeEventsFromCache(ArrayList<Event> cache){
        for(Event event: cache) super.logEvent(event);
    }

    public void destroy() throws IOException {
        if( !cache.isEmpty()){
            writeEventsFromCache(cache);
        }
    }

}
