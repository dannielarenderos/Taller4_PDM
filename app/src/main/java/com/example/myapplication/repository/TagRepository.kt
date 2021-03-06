package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.database.DAO.TagDAO
import com.example.myapplication.database.Entities.TagEntity

class TagRepository(private val tagDao: TagDAO) {

    val allTags: LiveData<List<TagEntity>> = tagDao.getTags()

    suspend fun insertTag(Tag: TagEntity) {
        tagDao.insert_tag(Tag)
    }
}