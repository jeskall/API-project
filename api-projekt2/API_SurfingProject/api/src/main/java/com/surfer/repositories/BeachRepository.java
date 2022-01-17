package com.surfer.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.surfer.Entities.Beach;

import org.springframework.stereotype.Service;

@Service
public class BeachRepository {

    Map<Long, Beach> beaches = new HashMap<Long, Beach>();

    public Collection<Beach> getAll() {
        return beaches.values();
    }

    public Beach getByID(Long id) {
        return beaches.get(id);
    }

    public Beach addBeach(Beach beach) {
        beaches.put(beach.getId(), beach);
        return beaches.get(beach.getId());
    }

    public Beach updateBeach(Long id, Beach beach) {
        beaches.put(id, beach);
        return beaches.get(id);
    }

    public void deleteHabit(Long id) {
        beaches.remove(id);
    }
}