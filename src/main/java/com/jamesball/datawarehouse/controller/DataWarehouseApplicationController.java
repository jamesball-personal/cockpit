package com.jamesball.datawarehouse.controller;

import com.jamesball.datawarehouse.entity.Snapshot;
import com.jamesball.datawarehouse.exception.SnapshotNotFoundException;
import com.jamesball.datawarehouse.service.SnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/dwa")
public class DataWarehouseApplicationController {

    private SnapshotService snapshotService;

    @Autowired
    public void setSnapshotService(SnapshotService snapshotService) {
        this.snapshotService = snapshotService;
    }

    @GetMapping("/snapshot")
    public ResponseEntity<List<Snapshot>> getAllSnapshots() {
        List<Snapshot> snapshots = snapshotService.findAllSnapshots();
        return new ResponseEntity<List<Snapshot>>(snapshots, HttpStatus.OK);
    }

    @GetMapping("/snapshot/{id}")
    public ResponseEntity<Snapshot> getSnapshot(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Snapshot>(snapshotService.findSnapshot(id), HttpStatus.OK);
        }
        catch (SnapshotNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Snapshot Not Found");
        }
    }
}