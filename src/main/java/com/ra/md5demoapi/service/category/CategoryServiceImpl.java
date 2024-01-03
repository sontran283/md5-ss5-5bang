package com.ra.md5demoapi.service.category;

import com.ra.md5demoapi.model.entity.Category;
import com.ra.md5demoapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        Page<Category> categoryPage=categoryRepository.findAll(pageable);
        return categoryPage.map(category -> new Category(category.getId(), category.getCategoryName(), category.getStatus()));
    }

    @Override
    public Page<Category> searchByName(Pageable pageable,String name) {
        Page<Category> categoryPage=categoryRepository.findAllByCategoryNameContainingIgnoreCase(pageable, name);
        return categoryPage.map(category -> new Category(category.getId(), category.getCategoryName(), category.getStatus()));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category saveOrUpdate(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        return category.orElse(null);
    }
}
