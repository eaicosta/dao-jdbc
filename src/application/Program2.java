package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department dep = depDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: Department findAll ===");
		List<Department> listDep = depDao.findAll();
		listDep.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: Department insert ===");
		Department depTeste = new Department(null, "Food");
		depDao.insert(depTeste);
		System.out.println("Inserted! New id = " + depTeste.getId());
		
		System.out.println("\n=== TEST 4: Department update ===");
		dep = depDao.findById(1);
		dep.setName("Games");
		depDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 5: Department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
