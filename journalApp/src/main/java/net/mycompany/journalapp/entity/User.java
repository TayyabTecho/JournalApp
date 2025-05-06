package net.mycompany.journalapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Indexed;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity//JournalEntry ka jo ek instance hoga vo db m ek document mtlb ek row k brabr hoga
@Table(name = "user_s")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //CHECK IN BOTH YT//
    private Long id;
    @Column(unique = true, nullable = false)
    private String userName;
    //@Column(nullable = false)
    @NonNull
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<JournalEntry> journalEntries = new ArrayList<>();
    private List<String> roles;
}