package com.example.fithcmusinfo.data

import com.example.fithcmusinfo.R

data class Lecturer(
    val firstName: String,
    val lastName: String,
    val honorific: String,
    val title: String,
    val email: String,
    val phone: String,
    val imageResourceID: Int
) {
    companion object {
        val lecturers = arrayOf(
            Lecturer(
                firstName = "Tien",
                lastName = "Dinh Ba",
                honorific = "Dr.",
                title = "Dean",
                email = "dbtien@fit.hcmus.edu.vn",
                phone = "0123456789",
                imageResourceID = R.drawable.dbtien
            ),
            Lecturer(
                firstName = "Vu",
                lastName = "Nguyen Van",
                honorific = "Assoc Prof.",
                title = "Vice Dean",
                email = "nvu@fit.hcmus.edu.vn",
                phone = "0000000000",
                imageResourceID = R.drawable.nvu
            ),
            Lecturer(
                firstName = "Vu",
                lastName = "Lam Quang",
                honorific = "Dr.",
                title = "Vice Dean",
                email = "lqvu@fit.hcmus.edu.vn",
                phone = "0987654321",
                imageResourceID = R.drawable.lqvu
            ),
            Lecturer(
                firstName = "Nam",
                lastName = "Van Chi",
                honorific = "Mr.",
                title = "Vice Dean",
                email = "vcnam@fit.hcmus.edu.vn",
                phone = "0192837465",
                imageResourceID = R.drawable.vcnam
            )
        )
    }
}
