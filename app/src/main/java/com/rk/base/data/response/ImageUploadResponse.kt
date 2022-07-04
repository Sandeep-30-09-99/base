package com.rk.base.data.response

data class ImageUploadResponse(
    val AWSSignedUrl: List<String>,
    val fileUrl: String
)