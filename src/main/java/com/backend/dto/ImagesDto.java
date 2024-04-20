package com.backend.dto;

public class ImagesDto {
	 private Long imageId;
	    private String name;
	    private String url;
	    private String code;
		
		public Long getImageId() {
			return imageId;
		}
		public void setImageId(Long imageId) {
			this.imageId = imageId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
}
