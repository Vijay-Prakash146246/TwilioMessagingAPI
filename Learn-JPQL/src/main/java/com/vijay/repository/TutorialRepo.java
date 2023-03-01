package com.vijay.repository;
import com.vijay.entities.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Repository
public interface TutorialRepo extends JpaRepository<Tutorial,Long>
{
    //JPA Select query with where condition example
    @Query("SELECT t FROM Tutorial t")
    List<Tutorial>findAll();
    @Query("SELECT t FROM Tutorial t WHERE t.published=?1")
    List<Tutorial>findByPublished(boolean isPublishhed);
    @Query("SELECT t FROM Tutorial t WHERE t.title LIKE %?1%")
    List<Tutorial>findByTitleLike(String title );
    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%',?1,'%'))")
    List<Tutorial>findByTitleLikeCaseInsensitive(String title);
    //JPA Query Greater Than or Equal To
    @Query("SELECT t FROM Tutorial t WHERE t.level >= ?1")
    List<Tutorial>findByLevelGreaterThanEqual(int level);
    @Query("SELECT t FROM Tutorial t WHERE t.createdAt >= ?1")
    List<Tutorial>findByDateGreaterThanEqual(int level);
    //JPA Query Between
    @Query("SELECT t FROM Tutorial t WHERE t.level BETWEEN ?1 AND ?2")
    List<Tutorial>findByLevelBetween(int start,int end);
    @Query("SELECT t FROM Tutorial t WHERE t.createdAt BETWEEN ?1 AND ?2")
    List<Tutorial>findByDateBetween(Date start, Date end);
    //JPA Query example with parameters
    @Query("SELECT t FROM Tutorial t WHERE t.published=:isPublished AND t.level BETWEEN :start AND :end")
    List<Tutorial>findByLevelBetween(@Param("isPublished") boolean isPublished,@Param("start")int start,@Param("end") int end);
    //JPA Query Order By Desc/Asc
    @Query("SELECT t FROM Tutorial t ORDER BY t.level DESC")
    List<Tutorial>findALLOrderByLevelDesc();
    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%',?1,'%')) ORDER BY t.level ASC")
    List<Tutorial>findTitleOrderByLevelAsc(String title);
    @Query("SELECT t FROM Tutorial t WHERE t.published=true ORDER BY t.createdAt DESC")
    List<Tutorial>findAllPublishedOrderBYCreatedDesc();
    //JPA Query Sort By
    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%',?1,'%'))")
    List<Tutorial>findTitleAndSort(String title, Sort sort);
    @Query("SELECT t FROM Tutorial t WHERE t.published=?1")
    List<Tutorial>findPublishedAndSort(Boolean isPublished, Sort sort);
    //JPA Query Pagination
    @Query("SELECT t FROM Tutorial")
    Page<Tutorial>findAllWithPagination(Pageable pageable);
    //JPA Query Update
    @Transactional
    @Modifying
    @Query("UPDATE Tutorial t SET t.published=true WHERE t.id=?1")
    int publishedTutorial(Long id);

}
