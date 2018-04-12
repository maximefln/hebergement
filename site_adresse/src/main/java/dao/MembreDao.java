package dao;

import entities.Membre;

import java.util.List;

public interface MembreDao {

    List<Membre> ListMembre();
    void addMembre (Membre membre);
    void deleteMembre (int id);

}
