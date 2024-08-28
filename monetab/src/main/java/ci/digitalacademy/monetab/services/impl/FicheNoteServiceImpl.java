package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.repositories.FicheNoteRepository;
import ci.digitalacademy.monetab.services.FicheNoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FicheNoteServiceImpl implements FicheNoteService {

    private final FicheNoteRepository ficheNoteRepository;

    @Override
    public FicheNote save(FicheNote ficheNote) {
        return ficheNoteRepository.save(ficheNote);
    }

    @Override
    public FicheNote update(FicheNote ficheNote) {
        log.debug("Request to update fiche note {}", ficheNote);
        // return null;

        Optional<FicheNote> optionalFicheNote = findOne(ficheNote.getId());
        if (optionalFicheNote.isPresent()) {
            FicheNote ficheNoteToUpdate = optionalFicheNote.get();
            ficheNoteToUpdate.setNote(ficheNote.getNote());
            ficheNoteToUpdate.setAnnee(ficheNote.getAnnee());
            return save(ficheNoteToUpdate);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<FicheNote> findOne(Long id) {
        log.debug("Request to find one fiche note {}", id);
        return ficheNoteRepository.findById(id);
    }

    @Override
    public List<FicheNote> findAll() {
        log.debug("Request to find all fiche note");
        return ficheNoteRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete fiche note {}", id);
        ficheNoteRepository.deleteById(id);
    }
}
