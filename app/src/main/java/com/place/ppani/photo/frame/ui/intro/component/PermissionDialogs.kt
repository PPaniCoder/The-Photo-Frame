package com.place.ppani.photo.frame.ui.intro.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun PermissionRationaleDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("사진 접근 권한") },
        text = { Text("포토 프레임 앱이 갤러리의 사진을 표시하려면 저장공간 접근 권한이 필요합니다.") },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("권한 허용")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("취소")
            }
        }
    )
}

@Composable
fun PermissionDeniedDialog(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("권한 필요") },
        text = { Text("사진 접근 권한 없이는 앱을 사용할 수 없습니다.") },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("확인")
            }
        }
    )
}
