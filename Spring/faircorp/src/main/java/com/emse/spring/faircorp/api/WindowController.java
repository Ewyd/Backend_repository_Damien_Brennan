package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.*;
import com.emse.spring.faircorp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController  // (1)
@RequestMapping("/api/lights") // (2)
@Transactional // (3)
public class WindowController {

    @Autowired
    private WindowDao windowDao; // (4)
    @Autowired
    private RoomDao roomDao;


    @GetMapping // (5)
    public List<WindowDto> findAll() {
        return windowDao.findAll()
                .stream()
                .map(WindowDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public WindowDto findById(@PathVariable Long id) {
        return windowDao.findById(id).map(light -> new WindowDto(light)).orElse(null);
    }

    @CrossOrigin
    @PutMapping(path = "/{id}/switch")
    public WindowDto switchStatus(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        return new WindowDto(window);
    }


    @CrossOrigin
    @PostMapping
    public WindowDto create(@RequestBody WindowDto dto) {
        Window window = null;
        Room room = roomDao.getOne(dto.getRoomId());
        if (dto.getId() != null) {
            window = windowDao.findById(dto.getId()).orElse(null);
        }

        if (window == null) {
            window = windowDao.save(new Window(room, dto.getName(), dto.getWindowStatus()));
        } else {
            window.setName(dto.getName());
            window.setWindowStatus(dto.getWindowStatus());
            windowDao.save(window);
        }

        return new WindowDto(window);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }
}
