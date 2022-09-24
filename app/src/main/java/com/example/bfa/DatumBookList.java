package com.example.bfa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatumBookList {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("book_category_id")
        @Expose
        private Integer bookCategoryId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("published_at")
        @Expose
        private String publishedAt;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("summary")
        @Expose
        private String summary;
        @SerializedName("isbn")
        @Expose
        private String isbn;
        @SerializedName("total_copies")
        @Expose
        private Integer totalCopies;
        @SerializedName("available_copies")
        @Expose
        private Integer availableCopies;
        @SerializedName("owner")
        @Expose
        private Owner owner;
        @SerializedName("book_category")
        @Expose
        private BookCategory bookCategory;
        @SerializedName("user_books")
        @Expose
        private List<Object> userBooks = null;
        @SerializedName("genres")
        @Expose
        private List<Genre> genres = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getBookCategoryId() {
            return bookCategoryId;
        }

        public void setBookCategoryId(Integer bookCategoryId) {
            this.bookCategoryId = bookCategoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public Integer getTotalCopies() {
            return totalCopies;
        }

        public void setTotalCopies(Integer totalCopies) {
            this.totalCopies = totalCopies;
        }

        public Integer getAvailableCopies() {
            return availableCopies;
        }

        public void setAvailableCopies(Integer availableCopies) {
            this.availableCopies = availableCopies;
        }

        public Owner getOwner() {
            return owner;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public BookCategory getBookCategory() {
            return bookCategory;
        }

        public void setBookCategory(BookCategory bookCategory) {
            this.bookCategory = bookCategory;
        }

        public List<Object> getUserBooks() {
            return userBooks;
        }

        public void setUserBooks(List<Object> userBooks) {
            this.userBooks = userBooks;
        }

        public List<Genre> getGenres() {
            return genres;
        }

        public void setGenres(List<Genre> genres) {
            this.genres = genres;
        }

    }

