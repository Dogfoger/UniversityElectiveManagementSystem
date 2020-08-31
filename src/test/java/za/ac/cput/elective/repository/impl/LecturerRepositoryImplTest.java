package za.ac.cput.elective.repository.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.entity.Lecturer;
import za.ac.cput.elective.factory.GenderFactory;
import za.ac.cput.elective.factory.LecturerFactory;
import za.ac.cput.elective.repository.LecturerRepository;

/**
 * @author @WilliamHenryKing
 * Desc: Test for LecturerRepository
 * Date: 2020/08/30
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LecturerRepositoryImplTest {

    private static LecturerRepository lecturerRepository = LecturerRepositoryImpl.getLecturerRepository();
    private static Gender maleGender = GenderFactory.createGender(Gender.genderIs.MALE);
    private static Lecturer originalLecturer = LecturerFactory.createLecturer(621548793
            , "Anikwue"
            , "Arinze"
            , maleGender);

    @Test
    public void a_create() {
        Lecturer createdLecturer = lecturerRepository.create(originalLecturer);
        Assert.assertEquals(originalLecturer.getLecturerID(), createdLecturer.getLecturerID());
        System.out.println("\nCreated: " + createdLecturer);
    }

    @Test
    public void b_read() {
        Lecturer read = lecturerRepository.read(originalLecturer.getLecturerID());
        System.out.println("\nTo String:\n" + read.toString());
    }

    @Test
    public void c_update() {
        Lecturer updated = new Lecturer
                .Builder()
                .copy(originalLecturer)
                .setLecturerID(621548798) // corrected a single number
                .build();

        updated = lecturerRepository.update(updated);
        System.out.println("\nUpdated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleteSuccessful = lecturerRepository.delete(originalLecturer.getLecturerID());
        Assert.assertTrue(deleteSuccessful);
    }

    @Test
    public void d_getAll() {
        System.out.println("\nDisplay All: " + lecturerRepository.getAll());
    }
}