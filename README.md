<a name="readme-top"></a>

<div align="center">
  
<!-- PROJECT SHIELDS -->
</div>
<h2 align="center">WGU C195 - Scheduling Application</h2>

  <p align="center">
    Scheduling Application created in Java for Software II at WGU

</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
<div align="center"><img src="https://github.com/Xander180/WGU-C195-SchedulingApplication/assets/67243244/334c9f20-9b33-41db-b1cf-57bdb066b732" height="200px" alt-text="image"></div></br>
Mock scheduling application where one can create, update, and delete appointments and customers to/from an SQL database. The database schema is no longer available as it was accessible solely for project completion.  


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With
<div align="center">
  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

</div>

* <b>IDE:</b> IntelliJ IDEA 2023.2.2 (Community Edition) x64
* <b>JDK:</b> Java 17.0.3
* <b>JavaFX:</b> JAVAFX.SDK.18.0.1
* <b>MySQL Connector Driver:</b> mysql-connector-java-8.0.25.jar
 

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Usage
How to run program:</br>
Username: test</br>
Password: test

Launch program and enter username and password (username and password are case sensitive) on login screen and click the login button or cancel to exit the program.</br>

User will receive an alert if username or password is incorrect. Once the user has been validated and logged in - an alert will be display letting the user know if there are any appointments within 15 minutes or not.

<b>MAIN MENU:</b></br>
After the appointment notification, the user will be directed to the main menu where 4 buttons will appear on the screen.

<b>APPOINTMENT:</b></br>
The appointment button will lead the user to a screen that displays all existing appointments by default. At the top middle of the screen, the user can select from all appointments, the next rolling week and the
next rolling month appointments by selecting the appropriate radio button.  Underneath the table on the left-hand side, there are 3 buttons. The update button will allow the user to update an existing
appointment, the add button will allow a user to create a new appointment and the delete button will allow the user to delete the selected appointment from the system.
The back to menu button will take you back to the main menu screen.

<b>CUSTOMER:</b></br>
The customer button will lead to the customer list and provide a table with all the available customer's information. Underneath the table on the left-hand side, there are 3 buttons.
The update button will allow you to update an existing contact, the add button will allow you to create a new customer, and delete will allow you to remove an existing customer from the system.
The back to menu button will take you back to the main menu screen.

<b>REPORTS:</b></br>
The report button will take you to the report list where there will be three tabs. Each tab has its own report, Appointment Totals, Contact Schedules and Customer Totals by Country.
The appointment totals tab displays the different appointment types and their associated totals. In addition, on the right side of the appointment totals tab, the appointment totals are broken down by month.
The contact schedules tab has a combobox that allows you to select a contact and will display appointments associated with the content in the tableview.

<B>REPORT A3F:</b></br> The Customer Totals By Country tab shows the number of Customers per country.

<b>LOG OUT:</b></br>
The log out button will display a confirmation box to confirm if you would like to log out. If "OK" is confirmed, you will be returned to the login screen.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/mriffey1/C195-Scheduling.svg?style=for-the-badge
[contributors-url]: https://github.com/mriffey1/C195-Scheduling/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mriffey1/C195-Scheduling.svg?style=for-the-badge
[forks-url]: https://github.com/mriffey1/C195-Scheduling/network/members
[stars-shield]: https://img.shields.io/github/stars/mriffey1/C195-Scheduling.svg?style=for-the-badge
[stars-url]: https://github.com/mriffey1/C195-Scheduling/stargazers
[issues-shield]: https://img.shields.io/github/issues/mriffey1/C195-Scheduling.svg?style=for-the-badge
[issues-url]: https://github.com/mriffey1/C195-Scheduling/issues
[license-shield]: https://img.shields.io/github/license/mriffey1/C195-Scheduling.svg?style=for-the-badge
[license-url]: https://github.com/mriffey1/C195-Scheduling/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/mriffey
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
