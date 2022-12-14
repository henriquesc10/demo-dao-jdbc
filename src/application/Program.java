package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.implement.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);

        for (Seller obj : sellerList) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Seller findAll ===");
        sellerList = sellerDao.findAll();
        for (Seller obj : sellerList) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: Seller insert ===");
        Seller insertSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(insertSeller);
        System.out.println("Inserted! New id: " + insertSeller.getId());

        System.out.println("\n=== TEST 5: Seller Upadte ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update Completed!");

        System.out.println("\n=== TEST 6: seller delete ===");
        System.out.print("Enter id for delete test: ");
        int id = scanner.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete Completed!");
    }
}
