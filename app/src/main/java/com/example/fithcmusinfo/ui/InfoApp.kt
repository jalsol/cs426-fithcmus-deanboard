package com.example.fithcmusinfo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.fithcmusinfo.R
import com.example.fithcmusinfo.data.Lecturer
import com.example.fithcmusinfo.domain.mail.composeEmail
import com.example.fithcmusinfo.domain.phone.dialPhoneNumber
import com.lighttigerxiv.catppuccin_kt.getLatteColors

@Preview
@Composable
fun InfoApp() {
    Surface(
        color = Color(getLatteColors().base.hex.asLong())
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            InfoAppBar()
            InfoCardList()
        }
    }
}

@Composable
fun InfoAppBar() {
    val logo = painterResource(id = R.drawable.fit_logo)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Spacing.appBar)
            .background(Color(getLatteColors().crust.hex.asLong())),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = logo,
            contentDescription = "fit@hcmus"
        )
    }
}

@Composable
fun InfoCardList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.padding)
    ) {
        items(items = Lecturer.lecturers) { lecturer ->
            Spacer(modifier = Modifier.height(Spacing.padding))
            InfoCard(lecturer)
        }
    }
    Spacer(modifier = Modifier.height(Spacing.padding))
}

@Composable
fun InfoCard(lecturer: Lecturer) {
    val (firstName, lastName, honorific, title, email, phone, imageResourceID) = lecturer
    val lecturerImage = painterResource(id = imageResourceID)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Spacing.cornerRadius))
            .background(Color(getLatteColors().mantle.hex.asLong()))
    ) {
        Row(
            modifier = Modifier
                .height(Spacing.cardHeight)
        ) {
            Image(
                painter = lecturerImage,
                contentDescription = null,
                modifier = Modifier.fillMaxHeight()
            )
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.weight(0.6f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = title, fontWeight = FontWeight.Bold)
                    Text(text = "$honorific $lastName, $firstName", fontWeight = FontWeight.Bold)
                    Text(text = email)
                }
                Row(
                    modifier = Modifier
                        .weight(0.4f)
                        .padding(horizontal = Spacing.padding)
                ) {
                    val context = LocalContext.current
                    Button(
                        onClick = { composeEmail(context, email) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(getLatteColors().mauve.hex.asLong())
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.padding(horizontal = Spacing.padding / 2))
                    Button(
                        onClick = { dialPhoneNumber(context, phone) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(getLatteColors().mauve.hex.asLong())
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}