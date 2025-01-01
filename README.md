# FeedbackApp

FeedbackApp is a simple web application built using Java Servlets. It allows users to submit feedback and view previously submitted feedback. This project is designed to demonstrate the use of Java Servlets for building dynamic web applications.

## Features
- Submit feedback through a form.
- View a list of submitted feedback.
- Simple and responsive UI.

## Technologies Used
- **Frontend**: HTML, CSS
- **Backend**: Java Servlets
- **Database**: MySQL (optional for persistent storage)
- **Server**: Apache Tomcat

## Project Structure
```
FeedbackApp
├── src
│   └── main
│       └── webapp
│           ├── css
│           ┌── js
│           ├── WEB-INF
│           └── index.html
└── target
```
- **`src/main/webapp`**: Contains the static resources and JSP files.
- **`WEB-INF`**: Stores configuration files and servlet mappings.

## Setup Instructions

### Prerequisites
- JDK (Java Development Kit)
- Apache Tomcat
- MySQL (optional for persistence)
- Maven (optional for dependency management)

### Steps
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/pratee-k-umar/FeedBack.git
   cd FeedbackApp
   ```

2. **Configure the Project**:
    - Ensure `web.xml` in the `WEB-INF` folder contains the correct servlet mappings.
    - If using MySQL, update the database connection details in the servlet class.

3. **Build the Project** (if using Maven):
   ```bash
   mvn clean install
   ```

4. **Deploy the Application**:
    - Copy the `target/FeedbackApp.war` file to the Tomcat `webapps` directory.
    - Start the Tomcat server.

5. **Access the Application**:
   Open your browser and navigate to:
   ```
   http://localhost:8080/FeedbackApp
   ```

## How It Works
- **Submit Feedback**:
  Users can fill out a feedback form, which sends data to the server using a POST request.
- **View Feedback**:
  The application retrieves and displays feedback data stored in memory (or in the database if configured).

## Example Servlet Code
```java
@WebServlet("/submitFeedback")
public class FeedbackServlet extends HttpServlet {
    private List<String> feedbackList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String feedback = request.getParameter("feedback");
        feedbackList.add(feedback);
        response.sendRedirect("viewFeedback.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("feedbackList", feedbackList);
        request.getRequestDispatcher("viewFeedback.jsp").forward(request, response);
    }
}
```

## Future Enhancements
- Add user authentication.
- Integrate with a database for persistent storage.
- Implement client-side validation for feedback form.

---

Feel free to contribute by opening issues or submitting pull requests!

