package com.notabnsol.jetpack_compose_assignment_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ElevatedButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import kotlin.math.exp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.notabnsol.jetpack_compose_assignment_1.ui.theme.JetpackComposeAssignment1Theme
import com.notabnsol.jetpack_compose_assignment_1.ui.theme.LightPrimary


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            JetpackComposeAssignment1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

val softwareCourses = listOf(
    CourseData(
        title = "Introduction to Programming",
        code = "CS101",
        creditHours = "3",
        description = "Fundamentals of programming using Python",
        prerequisites = "None"
    ),
    CourseData(
        title = "Object-Oriented Programming",
        code = "CS201",
        creditHours = "4",
        description = "Principles of OOP using Java",
        prerequisites = "CS101"
    ),
    CourseData(
        title = "Data Structures and Algorithms",
        code = "CS301",
        creditHours = "4",
        description = "Essential data structures and algorithm analysis",
        prerequisites = "CS201"
    ),
    CourseData(
        title = "Database Systems",
        code = "CS310",
        creditHours = "3",
        description = "Relational database design and SQL",
        prerequisites = "CS201"
    ),
    CourseData(
        title = "Web Development Fundamentals",
        code = "WD210",
        creditHours = "3",
        description = "HTML, CSS, and JavaScript basics",
        prerequisites = "CS101"
    ),
    CourseData(
        title = "Mobile App Development",
        code = "CS410",
        creditHours = "4",
        description = "Building Android/iOS applications",
        prerequisites = "CS301, WD210"
    ),
    CourseData(
        title = "Software Engineering",
        code = "CS450",
        creditHours = "3",
        description = "Software development lifecycle and methodologies",
        prerequisites = "CS301"
    ),
    CourseData(
        title = "Operating Systems",
        code = "CS320",
        creditHours = "4",
        description = "OS concepts and system programming",
        prerequisites = "CS301"
    ),
    CourseData(
        title = "Computer Networks",
        code = "CS330",
        creditHours = "3",
        description = "Network protocols and architectures",
        prerequisites = "CS201"
    ),
    CourseData(
        title = "Cloud Computing",
        code = "CS510",
        creditHours = "3",
        description = "Cloud platforms and distributed systems",
        prerequisites = "CS330"
    ),
    CourseData(
        title = "Machine Learning Fundamentals",
        code = "CS520",
        creditHours = "4",
        description = "Introduction to ML algorithms",
        prerequisites = "MATH250, CS301"
    ),
    CourseData(
        title = "Cybersecurity Basics",
        code = "CS430",
        creditHours = "3",
        description = "Information security principles",
        prerequisites = "CS330"
    ),
    CourseData(
        title = "DevOps Practices",
        code = "CS540",
        creditHours = "3",
        description = "CI/CD pipelines and infrastructure as code",
        prerequisites = "CS450"
    ),
    CourseData(
        title = "Frontend Frameworks",
        code = "WD320",
        creditHours = "3",
        description = "React/Angular/Vue.js development",
        prerequisites = "WD210"
    ),
    CourseData(
        title = "Backend Development",
        code = "WD330",
        creditHours = "4",
        description = "Server-side programming with Node.js/Spring",
        prerequisites = "CS310, WD210"
    ),
    CourseData(
        title = "Full-Stack Development",
        code = "WD400",
        creditHours = "4",
        description = "End-to-end web application development",
        prerequisites = "WD320, WD330"
    ),
    CourseData(
        title = "Game Development",
        code = "CS470",
        creditHours = "4",
        description = "Game design and development using Unity",
        prerequisites = "CS201"
    ),
    CourseData(
        title = "Blockchain Fundamentals",
        code = "CS480",
        creditHours = "3",
        description = "Cryptocurrency and smart contract basics",
        prerequisites = "CS301"
    ),
    CourseData(
        title = "UI/UX Design",
        code = "DES310",
        creditHours = "3",
        description = "User interface and experience principles",
        prerequisites = "None"
    ),
    CourseData(
        title = "Software Testing",
        code = "QA410",
        creditHours = "3",
        description = "Testing methodologies and automation",
        prerequisites = "CS301"
    ),
    CourseData(
        title = "Artificial Intelligence",
        code = "CS550",
        creditHours = "4",
        description = "AI concepts and problem solving",
        prerequisites = "CS520"
    ),
    CourseData(
        title = "Big Data Technologies",
        code = "CS560",
        creditHours = "3",
        description = "Hadoop, Spark, and data processing",
        prerequisites = "CS310"
    ),
    CourseData(
        title = "Embedded Systems",
        code = "CS340",
        creditHours = "4",
        description = "Programming for hardware devices",
        prerequisites = "CS201, EE210"
    ),
    CourseData(
        title = "Compiler Design",
        code = "CS570",
        creditHours = "4",
        description = "Language processing systems",
        prerequisites = "CS301"
    ),
    CourseData(
        title = "Quantum Computing",
        code = "CS580",
        creditHours = "3",
        description = "Introduction to quantum algorithms",
        prerequisites = "MATH300, CS301"
    ),
    CourseData(
        title = "Natural Language Processing",
        code = "CS530",
        creditHours = "3",
        description = "Text processing and language models",
        prerequisites = "CS520"
    ),
    CourseData(
        title = "Computer Graphics",
        code = "CS460",
        creditHours = "4",
        description = "2D/3D rendering techniques",
        prerequisites = "MATH250, CS201"
    ),
    CourseData(
        title = "Parallel Computing",
        code = "CS590",
        creditHours = "3",
        description = "Multithreading and distributed processing",
        prerequisites = "CS320"
    ),
    CourseData(
        title = "Software Architecture",
        code = "CS600",
        creditHours = "3",
        description = "Design patterns and system design",
        prerequisites = "CS450"
    ),
    CourseData(
        title = "Ethical Hacking",
        code = "CS440",
        creditHours = "3",
        description = "Penetration testing techniques",
        prerequisites = "CS430"
    )
)

@Composable
fun MyApp(
    modifier : Modifier = Modifier,
){

    var showOnBoarding by rememberSaveable { mutableStateOf(true) }

    if (showOnBoarding){
        OnBoardingScreen(onContinueClicked = { showOnBoarding = false})
    }else{
        CourseList(courses = softwareCourses)
    }
}

@Composable
fun CourseList(
    modifier : Modifier = Modifier,
    courses : List<CourseData>
) {
    Surface (
        modifier = modifier.padding(vertical = 4.dp).background(color = MaterialTheme.colorScheme.surface),
    ){

        LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
            item {Spacer(modifier = Modifier.height(8.dp))}
            item { Header() }
            items (items = courses) { course ->
                CourseCard(course = course)
            }
        }
    }
}

@Composable
fun CourseCard(course: CourseData) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (expanded) 8.dp else 2.dp
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    // Course Title with Code
                    Text(
                        text = "${course.code}: ${course.title}",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Credit Hours
                    Text(
                        text = "${course.creditHours} Credit Hours",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Expand/Collapse Button
                IconButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = CircleShape
                        )
                        .size(36.dp)
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (expanded) "Show less" else "Show more",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            // Expanded content
            if (expanded) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    // Description
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = course.description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    // Prerequisites
                    Text(
                        text = "Prerequisites",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = course.prerequisites,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    JetpackComposeAssignment1Theme {
        CourseList(courses = softwareCourses)
    }
}

@Composable
fun OnBoardingScreen(
    onContinueClicked : () -> Unit,
    modifier : Modifier = Modifier) {
    Column (modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "Review Your Courses")
        Button(
            onClick = onContinueClicked,
            modifier = Modifier
                .padding(vertical = 24.dp)
        ) {
            Text(text = "Get Started")
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun OnBoardingScreenPrev() {
    JetpackComposeAssignment1Theme {
        OnBoardingScreen(onContinueClicked = {})
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    JetpackComposeAssignment1Theme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Composable
fun Header (modifier : Modifier = Modifier) {
    Text( text = "Courses",
        modifier = modifier.padding(16.dp),
        style = MaterialTheme.typography.headlineMedium,
        color = LightPrimary,
        fontWeight = FontWeight.Bold
    )

}

