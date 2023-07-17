package ru.rutmiit.Library.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.Library.dtos.ReaderDto;
import ru.rutmiit.Library.entities.Reader;
import ru.rutmiit.Library.repositories.ReaderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ReaderService() {
    }

    public List<ReaderDto> getAll(){
        return (List)this.readerRepository.findAll().stream().map((s) -> {
            return (ReaderDto)this.modelMapper.map(s, ReaderDto.class);
        }).collect(Collectors.toList());
    }

    public Optional<Reader>  getReaderById (Long readerId) {
        return readerRepository.findById(readerId);
    }

    public Reader updateReader(Long readerId, Reader updatedReader) {
        Optional<Reader> existingReaderOptional = readerRepository.findById(readerId);
        if (existingReaderOptional.isPresent()) {
            Reader existingReader = existingReaderOptional.get();
            existingReader.setName(updatedReader.getName());
            existingReader.setEmail(updatedReader.getEmail());
            existingReader.setAddress(updatedReader.getAddress());
            existingReader.setPhone(updatedReader.getPhone());
            return readerRepository.save(existingReader);
        } else {
            throw new IllegalArgumentException("Reader with ID " + readerId + " not found.");
        }
    }
    public Reader createReader(Reader reader){
        return readerRepository.save(reader);
    }

    public void deleteReader(Long readerId){
        readerRepository.deleteById(readerId);
    }

    public ReaderDto addReader(ReaderDto newReader) {
        Reader b = (Reader)this.modelMapper.map(newReader, Reader.class);
        return (ReaderDto)this.modelMapper.map(this.readerRepository.save(b), ReaderDto.class);
    }

    public Optional<ReaderDto> findReader(long readerId) {
        return Optional.ofNullable((ReaderDto)this.modelMapper.map(this.readerRepository.findById(readerId), ReaderDto.class));
    }

    public Optional<ReaderDto> findReaderByName(String name) {
        return Optional.ofNullable((ReaderDto) this.modelMapper.map(this.readerRepository.findByName(name), ReaderDto.class));
    }

    public Optional<ReaderDto> findReaderByEmail(String email) {
        return Optional.ofNullable((ReaderDto) this.modelMapper.map(this.readerRepository.findByEmail(email), ReaderDto.class));
    }

    public Optional<Object> findReaderByAddress(String address) {
        return Optional.ofNullable((ReaderDto) this.modelMapper.map(this.readerRepository.findByAddress(address), ReaderDto.class));
    }

    public Optional<Object> findReaderByPhone(String phoneNumber) {
        return Optional.ofNullable((ReaderDto) this.modelMapper.map(this.readerRepository.findByPhone(phoneNumber), ReaderDto.class));
    }
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

}

