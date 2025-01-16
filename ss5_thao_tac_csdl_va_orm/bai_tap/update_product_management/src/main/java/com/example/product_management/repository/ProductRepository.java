package com.example.product_management.repository;

import com.example.product_management.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("IPhone 11", 12000000, "Tốt"));
        products.add(new Product("IPhone 12", 14000000, "Tốt"));
        products.add(new Product("IPhone 13", 16000000, "Tốt"));
        products.add(new Product("IPhone 14", 18000000, "Tốt"));
        products.add(new Product("Samsung", 20000000, "Tốt"));

    }

    @PersistenceContext
    private EntityManager entityManager;
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ",Product.class);
        return query.getResultList();
    }

    @Transactional
    public boolean save(Product product) {
        try{
            entityManager.persist(product);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Product getById(int id) {
       return entityManager.find(Product.class, id);
    }

    @Transactional
    public void update(Product updatedProduct) {
        try{
            entityManager.merge(updatedProduct);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void delete(int id) {
        Product product = getById(id);
        if(product != null){
            try {
                entityManager.remove(product);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Product> search(String name) {
       TypedQuery<Product> query = entityManager.createQuery("from Product where name like :name",Product.class);
       query.setParameter("name", "%"+name.toLowerCase()+"%");
       return query.getResultList();
    }

}
