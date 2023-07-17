package ru.rutmiit.Library.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.Library.dtos.LibrarianDto;
import ru.rutmiit.Library.dtos.ReaderDto;
import ru.rutmiit.Library.entities.Librarian;
import ru.rutmiit.Library.entities.Reader;
import ru.rutmiit.Library.repositories.LibrarianRepository;
import ru.rutmiit.Library.repositories.ReaderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibrarianService {


        @Autowired
        private LibrarianRepository librarianRepository;

        @Autowired
        private ModelMapper modelMapper;

        @Autowired
        public LibrarianService() {
        }

        public List<LibrarianDto> getAll(){
            return (List)this.librarianRepository.findAll().stream().map((s) -> {
                return (LibrarianDto)this.modelMapper.map(s, LibrarianDto.class);
            }).collect(Collectors.toList());
        }

        public Optional<Librarian> getLibrarianById (Integer librarianId) {
            return librarianRepository.findById(librarianId);
        }

        public Librarian updateLibrarian(Integer librarianId, Librarian updatedLibrarian) {
            Optional<Librarian> existingLibrarianOptional = librarianRepository.findById(librarianId);
            if (existingLibrarianOptional.isPresent()) {
                Librarian existingLibrarian = existingLibrarianOptional.get();
                existingLibrarian.setName(updatedLibrarian.getName());
                existingLibrarian.setEmail(updatedLibrarian.getEmail());
                existingLibrarian.setAddress(updatedLibrarian.getAddress());
                existingLibrarian.setPhone(updatedLibrarian.getPhone());
                return librarianRepository.save(existingLibrarian);
            } else {
                throw new IllegalArgumentException("Librarian with ID " + librarianId + " not found.");
            }
        }
        public Librarian createReader(Librarian librarian){
            return librarianRepository.save(librarian);
        }

        public void deleteLibrarian(Integer librarianId){
            librarianRepository.deleteById(librarianId);
        }

        public LibrarianDto addLibrarian(LibrarianDto newLibrarian) {
            Librarian b = (Librarian)this.modelMapper.map(newLibrarian, Librarian.class);
            return (LibrarianDto)this.modelMapper.map(this.librarianRepository.save(b), LibrarianDto.class);
        }

        public Optional<LibrarianDto> findLibrarian(Integer librarianId) {
            return Optional.ofNullable((LibrarianDto)this.modelMapper.map(this.librarianRepository.findById(librarianId), LibrarianDto.class));
        }

        public Optional<LibrarianDto> findLibrarianByName(String name) {
            return Optional.ofNullable((LibrarianDto) this.modelMapper.map(this.librarianRepository.findByName(name), LibrarianDto.class));
        }

        public Optional<LibrarianDto> findLibrarianByEmail(String email) {
            return Optional.ofNullable((LibrarianDto) this.modelMapper.map(this.librarianRepository.findByEmail(email), LibrarianDto.class));
        }

        public Optional<Object> findLibrarianByAddress(String address) {
            return Optional.ofNullable((LibrarianDto) this.modelMapper.map(this.librarianRepository.findByAddress(address), LibrarianDto.class));
        }

        public Optional<Object> findLibrarianByPhone(String phoneNumber) {
            return Optional.ofNullable((LibrarianDto) this.modelMapper.map(this.librarianRepository.findByPhone(phoneNumber), LibrarianDto.class));
        }
        public List<Librarian> getAllLibrarian() {
            return librarianRepository.findAll();
        }

}

