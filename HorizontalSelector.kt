import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import de.writer_chris.jpcbasiccodelabpart2.R


@Composable
fun <T> HorizontalSelector(
    title: T,
    callback: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row() {
            IconButton(onClick = { callback(-1) }) {
                Icon(
                    imageVector = Icons.Filled.ChevronLeft,
                    contentDescription = stringResource(
                        id = R.string.previous
                    )
                )
            }
            Text(text = title.toString(), modifier = Modifier.align(Alignment.CenterVertically))
            IconButton(onClick = { callback(1) }) {
                Icon(
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = stringResource(
                        id = R.string.next
                    )
                )
            }
        }
    }
}
/**Example Code
// =============
@Preview
@Composable
fun HorizontalSelectorPreview() {
    YourAppTheme {
        var lastValue by remember {
            mutableStateOf(0)
        }
        HorizontalSelector(title = lastValue, callback = { lastValue = it })
    }
}
 **/