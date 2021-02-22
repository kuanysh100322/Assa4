package repositories.interfaces;


import entities.Medicine;

import java.util.ArrayList;
public interface ForMedRepos
{
    ArrayList<Medicine> searchByName(String name);
    Medicine getById(int id);

    boolean addMed(Medicine medicine);
    boolean removeMed(int id);
}
