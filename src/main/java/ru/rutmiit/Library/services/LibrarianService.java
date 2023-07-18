package ru.rutmiit.Library.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.Library.dtos.LibrarianDto;
import ru.rutmiit.Library.dtos.ReaderDto;
import ru.rutmiit.Library.entities.Librarian;
import ru.rutmiit.Library.entities.Reader;
import ru.rutmiit.Library.entities.Review;
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
        private ReaderRepository readerRepository;

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

        public Librarian createLibrarian(Librarian librarian){
            return librarianRepository.save(librarian);
        }

        public Librarian updateLibrarian(Integer librarianId, Librarian updatedLibrarian) {
            Optional<Librarian> existingLibrarianOptional = librarianRepository.findById(librarianId);
            if (existingLibrarianOptional.isPresent()) {
                Librarian existingLibrarian = existingLibrarianOptional.get();
                existingLibrarian.setName(updatedLibrarian.getName());
                existingLibrarian.setEmail(updatedLibrarian.getEmail());
                existingLibrarian.setAddress(updatedLibrarian.getAddress());
                existingLibrarian.setphoneNumber(updatedLibrarian.getphoneNumber());
                return librarianRepository.save(existingLibrarian);
            } else {
                throw new IllegalArgumentException("Librarian with ID " + librarianId + " not found.");
            }
        }

        public void deleteLibrarian(Integer librarianId){
            librarianRepository.deleteById(librarianId);
        }

        public LibrarianDto addLibrarian(LibrarianDto newLibrarian) {
            Librarian l = (Librarian)this.modelMapper.map(newLibrarian, Librarian.class);
            return (LibrarianDto)this.modelMapper.map(this.librarianRepository.save(l), LibrarianDto.class);
        }

        public Optional<LibrarianDto> findLibrarian(Integer librarianId) {
            return Optional.ofNullable((LibrarianDto)this.modelMapper.map(this.librarianRepository.findById(librarianId), LibrarianDto.class));
        }

    public List<LibrarianDto> findLibrariansByName(String name) {
        List<Librarian> librarians = librarianRepository.findByName(name);
        return librarians.stream()
                .map(librarian -> modelMapper.map(librarian, LibrarianDto.class))
                .collect(Collectors.toList());
    }




    public Optional<LibrarianDto> findLibrarianByEmail(String email) {
            return Optional.ofNullable((LibrarianDto) this.modelMapper.map(this.librarianRepository.findByEmail(email), LibrarianDto.class));
        }

        public Optional<Object> findLibrarianByAddress(String address) {
            return Optional.ofNullable((LibrarianDto) this.modelMapper.map(this.librarianRepository.findByAddress(address), LibrarianDto.class));
        }

        public Optional<Object> findLibrarianByphoneNumber(String phoneNumber) {
            return Optional.ofNullable((LibrarianDto) this.modelMapper.map(this.librarianRepository.findByphoneNumber(phoneNumber), LibrarianDto.class));
        }
        public List<Librarian> getAllLibrarian() {
            return librarianRepository.findAll();
        }



}

