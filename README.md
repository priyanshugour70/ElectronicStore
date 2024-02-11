project by :- Priyanshu Gour

# ElectronicStore

ElectronicStore is an e-commerce platform that allows users to browse and purchase electronic products online. This project aims to provide a complete end-to-end solution for running an electronic store.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Overview

ElectronicStore is a full-fledged e-commerce platform designed specifically for electronic products. It provides a user-friendly interface for browsing different categories of products, viewing product details, adding them to the cart, and securely completing the purchase.

This project is built using modern web technologies and follows best practices for scalability, security, and performance. It serves as a starting point for creating your own electronic store or as a reference implementation for learning e-commerce application development.

## Features

- User authentication and registration
- Product catalog with categories and search functionality
- Product details page with specifications, images, and reviews
- Shopping cart functionality with the ability to add, remove, and update items
- Secure checkout process with payment integration
- User account management with order history
- Admin panel for managing products, categories, and user accounts

## Prerequisites

Before getting started, ensure that you have the following prerequisites:

- Node.js (v14 or higher)
- Java (v17 or higher)

## 1. Installation

To install the project, you can use the following commands:

#### Install Docker and follow this command:
 For Starting the project
```
docker-compose up
```
 For Stopping the project
```
docker-compose down
```

## 2. Installation

Follow these steps to set up the ElectronicStore project locally:

1. Clone the repository.
```git
git clone https://github.com/priyanshugour70/ElectronicStore.git
```

2. Change into the project directory.
```
cd ElectronicStore
```

3. Configure the project.
```
:: ls
    ElectronicStoreBackend[Spring-boot]
    ElectronicStoreFronted[ReactJs]
    database[MySQL]
```

### Configuration Database (MySQL)
1. Create a MySQL database.
```
CREATE DATABASE electronic_store;
```

2. Change into the database directory.
```
cd database
```

3. Run the electronic_stoe.sql file.
```
mysql -u root -p < electronic_store.sql
```



### Configuration Backend (Spring-boot)
1. Change into the Backend directory.
```
cd ElectronicStoreBackend
```

2. Install dependencies.
```
mvn clean install
```

3. Run the application.
```
mvn spring-boot:run
```


### Configuration Frontend (ReactJs)
1. Change into the Fontend directory.
```
cd ElectronicStoreFrontend
```

2. Install dependencies.
```
npm install
```

3. Run the application.
```
npm start
```


## Contributing

We welcome contributions to enhance the ElectronicStore project. To contribute, please follow these guidelines:

- Fork the repository and create a new branch.
- Make your changes and test thoroughly.
- Submit a pull request, describing the changes you have made.



## License

Nothing special.


## Contact

For any inquiries or feedback, you can reach out to:

- Name: Priyanshu Gour
- LinkedIn: [Priyanshu Gour](https://www.linkedin.com/in/priyanshugour70/)
- Email: priyanshugour1@gamil.com

Feel free to reach out with any questions or collaboration opportunities.