package gois.study.sbobkspringwithhibernate.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class AudioController {
    private AudioObjectRepository audioObjectRepository;

    public AudioObjectRepository getAudioObjectRepository() {
        return audioObjectRepository;
    }

    @Autowired
    public void setAudioObjectRepository(AudioObjectRepository audioObjectRepository) {
        this.audioObjectRepository = audioObjectRepository;
    }

    @RequestMapping("/audio")
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<AudioObject> findAllAudio(@RequestParam("page") Integer page) {
        Pageable pageable = new PageRequest(page, 10);
        return this.audioObjectRepository.findAll(pageable);

    }
}
