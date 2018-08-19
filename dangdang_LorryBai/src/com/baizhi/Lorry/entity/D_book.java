package com.baizhi.Lorry.entity;

import java.io.Serializable;
import java.util.Date;

public class D_book implements Serializable{
		private Integer id;
		private String name;
		private String publish_company;
		private Date publish_time;
		private Integer publish_count;
		private Integer print_count; 
		private Integer word_count;
		private Integer page_count;
		private double dd_price;
		private double price;
		private Integer storagy_number;
		private Integer sale_count;
		private Integer sort_id;
		private String img_url;
		private String recommend;
		private Long ISBN;
		public D_book(){}
		public D_book(Integer id, String name, String publish_company,
				Date publish_time, Integer publish_count, Integer print_count,
				Integer word_count, Integer page_count, double dd_price,
				double price, Integer storagy_number, Integer sale_count,
				Integer sort_id, String img_url, String recommend, long iSBN) {
			super();
			this.id = id;
			this.name = name;
			this.publish_company = publish_company;
			this.publish_time = publish_time;
			this.publish_count = publish_count;
			this.print_count = print_count;
			this.word_count = word_count;
			this.page_count = page_count;
			this.dd_price = dd_price;
			this.price = price;
			this.storagy_number = storagy_number;
			this.sale_count = sale_count;
			this.sort_id = sort_id;
			this.img_url = img_url;
			this.recommend = recommend;
			this.ISBN = iSBN;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPublish_company() {
			return publish_company;
		}
		public void setPublish_company(String publish_company) {
			this.publish_company = publish_company;
		}
		public Date getPublish_time() {
			return publish_time;
		}
		public void setPublish_time(Date publish_time) {
			this.publish_time = publish_time;
		}
		public Integer getPublish_count() {
			return publish_count;
		}
		public void setPublish_count(Integer publish_count) {
			this.publish_count = publish_count;
		}
		public Integer getPrint_count() {
			return print_count;
		}
		public void setPrint_count(Integer print_count) {
			this.print_count = print_count;
		}
		public Integer getWord_count() {
			return word_count;
		}
		public void setWord_count(Integer word_count) {
			this.word_count = word_count;
		}
		public Integer getPage_count() {
			return page_count;
		}
		public void setPage_count(Integer page_count) {
			this.page_count = page_count;
		}
		public double getDd_price() {
			return dd_price;
		}
		public void setDd_price(double dd_price) {
			this.dd_price = dd_price;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Integer getStoragy_number() {
			return storagy_number;
		}
		public void setStoragy_number(Integer storagy_number) {
			this.storagy_number = storagy_number;
		}
		public Integer getSale_count() {
			return sale_count;
		}
		public void setSale_count(Integer sale_count) {
			this.sale_count = sale_count;
		}
		public Integer getSort_id() {
			return sort_id;
		}
		public void setSort_id(Integer sort_id) {
			this.sort_id = sort_id;
		}
		public String getImg_url() {
			return img_url;
		}
		public void setImg_url(String img_url) {
			this.img_url = img_url;
		}
		public String getRecommend() {
			return recommend;
		}
		public void setRecommend(String recommend) {
			this.recommend = recommend;
		}
		public Long getISBN() {
			return ISBN;
		}
		public void setISBN(Long iSBN) {
			ISBN = iSBN;
		}
		@Override
		public String toString() {
			return "D_book [id=" + id + ", name=" + name + ", publish_company="
					+ publish_company + ", publish_time=" + publish_time
					+ ", publish_count=" + publish_count + ", print_count="
					+ print_count + ", word_count=" + word_count
					+ ", page_count=" + page_count + ", dd_price=" + dd_price
					+ ", price=" + price + ", storagy_number=" + storagy_number
					+ ", sale_count=" + sale_count + ", sort_id=" + sort_id
					+ ", img_url=" + img_url + ", recommend=" + recommend
					+ ", ISBN=" + ISBN + "]";
		}
		
}