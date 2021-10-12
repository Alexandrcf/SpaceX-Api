package com.app.model

import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class DataClass (
	@SerializedName("fairings") val fairings : Fairings,
	@SerializedName("links") val links : Links,
	@SerializedName("static_fire_date_utc") val static_fire_date_utc : String,
	@SerializedName("static_fire_date_unix") val static_fire_date_unix : Int,
	@SerializedName("net") val net : Boolean,
	@SerializedName("window") val window : Int,
	@SerializedName("rocket") val rocket : String,
	@SerializedName("success") val success : Boolean,
	@SerializedName("failures") val failures : List<Failures>,
	@SerializedName("details") val details : String,
	@SerializedName("crew") val crew : List<String>,
	@SerializedName("ships") val ships : List<String>,
	@SerializedName("capsules") val capsules : List<String>,
	@SerializedName("payloads") val payloads : List<String>,
	@SerializedName("launchpad") val launchpad : String,
	@SerializedName("flight_number") val flight_number : Int,
	@SerializedName("name") val name : String,
	@SerializedName("date_utc") val date_utc : String,
	@SerializedName("date_unix") val date_unix : Int,
	@SerializedName("date_local") val date_local : String,
	@SerializedName("date_precision") val date_precision : String,
	@SerializedName("upcoming") val upcoming : Boolean,
	@SerializedName("cores") val cores : List<Cores>,
	@SerializedName("auto_update") val auto_update : Boolean,
	@SerializedName("tbd") val tbd : Boolean,
	@SerializedName("launch_library_id") val launch_library_id : String,
	@SerializedName("id") val id : String,

)