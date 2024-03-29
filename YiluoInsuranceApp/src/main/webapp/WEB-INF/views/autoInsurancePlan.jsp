<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Fernie's Autoinsurance Plan</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Raleway"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    />
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script
      type="text/javascript"
      src="${pageContext.request.contextPath}/js/autoInsurancePlan.js"
    ></script>
    <style>
      body,
      h1,
      h2,
      h3,
      h4,
      h5,
      h6 {
        font-family: "Raleway", Arial, Helvetica, sans-serif;
      }
      body {
        background-color: #f6f6f6;
        padding: 0%;
        margin: 0%;
      }
      @media (prefers-reduced-motion: reduce) {
        .modal.fade .modal-dialog {
          transition: none;
        }
      }
      .plan-card {
        margin: 0 auto;
        transition: transform .4s;
      }
      .plan-card:hover {
        transform: scale(1.05);
      }
      .fadeinTitle {
        font-size: 120px;
        text-align: left;
        animation: fadein 5s infinite;
        -moz-animation: fadein 5s infinite; /* Firefox */
        -webkit-animation: fadein 5s infinite; /* Safari and Chrome */
        -o-animation: fadein 5s infinite; /* Opera */
      }
      .top-left {
        position: absolute;
        top: 50px;
        left: 16px;
      }
      header {
        position: relative;
        text-align: left;
        color: whitesmoke;
      }

      @keyframes fadein {
          from {
              opacity:0;
          }
          to {
              opacity:1;
          }
      }
      @-moz-keyframes fadein { /* Firefox */
          from {
              opacity:0;
          }
          to {
              opacity:1;
          }
      }
      @-webkit-keyframes fadein { /* Safari and Chrome */
          from {
              opacity:0;
          }
          to {
              opacity:1;
          }
      }
      @-o-keyframes fadein { /* Opera */
          from {
              opacity:0;
          }
          to {
              opacity: 1;
          }
      }
    </style>
    
  </head>
  <body class="w3-light-grey">
    <!-- Navigation Bar -->
    <div class="w3-bar w3-white w3-large">
      <a href="${pageContext.request.contextPath}/home" class="w3-bar-item w3-button w3-red w3-mobile">Home</a>
      <a href="#rooms" class="w3-bar-item w3-button w3-mobile">Plans</a>
      <a href="#about" class="w3-bar-item w3-button w3-mobile">About</a>
      <a href="#contact" class="w3-bar-item w3-button w3-mobile">Contact</a>
      <a
        href="#contact"
        class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile"
        >Have an Inquiry</a
      >
    </div>
    <!-- Header -->
    <header class="w3-display-container w3-content" style="max-width: max-content">
      <img
        class="w3-image"
        src="${pageContext.request.contextPath}/images/lambo.jpg"
        alt="The Car"
        style="min-width: 1000px"
        width="1500"
        height="800"
      />
      <div class="top-left">
        <p class="fadeinTitle">Our Insurance Plans</p>
        <p class="fadeinTitle">Have No Speed Limits</p>  
        <!-- <p class="fadeinTitle">Speed Limits</p> -->
      </div>
    </header>

    <!-- Page content -->
    <div class="w3-content" style="max-width: 1532px">
      <div class="w3-container w3-margin-top" id="rooms">
        <h1>Explore Our Plans</h1>
      </div>
      <div class="w3-row-padding w3-padding-16">
        <div class="w3-third w3-margin-bottom plan-card">
          <img
            src="${pageContext.request.contextPath}/images/benz.jpg"
            alt="benz"
            style="width: 100%; max-height: 330px"
          />
          <div class="w3-container w3-white">
            <h3>Standard Plan</h3>
            <h6 class="w3-opacity">From $999</h6>
            <p>The insurance will pay up to $50,000 in injury-related expenses for each person involved in an accident</p>
            <p>The insurance will pay up to $100,000 in injury-related expenses per incident </p>  
            <p>The insurance will pay up to $25,000 for property damage per incident  </p> 
            <p>The insurance will pay up to $50,000 in injury-related expenses for each person involved in an accident</p>
            <p>The insurance will pay up to $100,000 in injury-related expenses per incident </p>  
            <p>The insurance will pay up to $25,000 for property damage per incident  </p>  
            <p class="w3-large">
              <i class="fa fa-car"></i> 
              <i class="fa fa-road"></i>
              <i class="fa fa-wifi"></i>
            </p>
            <button
            class="w3-button w3-block w3-black w3-margin-bottom"
            data-toggle="modal"
            data-target="#autoInsurancePlanUserRegistrationModal"
            id="StandardPlanChoosePlanBtn"
            >
            Learn More
            </button>
          </div>
        </div>
        <div class="w3-third w3-margin-bottom plan-card">
          <img
            src="${pageContext.request.contextPath}/images/porsche.jpg"
            alt="porsche"
            style="width: 100%"
          />
          <div class="w3-container w3-white">
            <h3>Premium Plan</h3>
            <h6 class="w3-opacity">From $1999</h6>
            <p>The insurance will pay up to $50,000 in injury-related expenses for each person involved in an accident</p>
            <p>The insurance will pay up to $100,000 in injury-related expenses per incident </p>  
            <p>The insurance will pay up to $25,000 for property damage per incident  </p>  
            <p>The insurance will pay up to $50,000 in injury-related expenses for each person involved in an accident</p>
            <p>The insurance will pay up to $100,000 in injury-related expenses per incident </p>  
            <p>The insurance will pay up to $25,000 for property damage per incident  </p> 
            <p class="w3-large">
              <i class="fa fa-car"></i>
              <i class="fa fa-road"></i>
              <i class="fa fa-phone"></i>
              <i class="fa fa-wifi"></i>
            </p>
            <button 
            class="w3-button w3-block w3-black w3-margin-bottom"
            data-toggle="modal"
            data-target="#autoInsurancePlanUserRegistrationModal"
            id="PremiumPlanChoosePlanBtn">
            Learn More
            </button>
          </div>
        </div>
        <div class="w3-third w3-margin-bottom plan-card">
          <img
            src="${pageContext.request.contextPath}/images/ferrari.jpg"
            alt="ferrari"
            style="width: 100%"
          />
          <div class="w3-container w3-white">
            <h3>Supreme Plan</h3>
            <h6 class="w3-opacity">From $3999</h6>
            <p>The insurance will pay up to $50,000 in injury-related expenses for each person involved in an accident</p>
            <p>The insurance will pay up to $100,000 in injury-related expenses per incident </p>  
            <p>The insurance will pay up to $25,000 for property damage per incident  </p>  
            <p>The insurance will pay up to $50,000 in injury-related expenses for each person involved in an accident</p>
            <p>The insurance will pay up to $100,000 in injury-related expenses per incident </p>  
            <p>The insurance will pay up to $25,000 for property damage per incident  </p> 
            <p class="w3-large">
              <i class="fa fa-car"></i> 
              <i class="fa fa-road"></i>
              <i class="fa fa-money"></i>
            </p>
            <button 
            class="w3-button w3-block w3-black w3-margin-bottom"
            data-toggle="modal"
            data-target="#autoInsurancePlanUserRegistrationModal"
            id="SupremePlanChoosePlanBtn">
              Learn More
            </button>
          </div>
        </div>
      </div>

      <div class="w3-row-padding" id="about">
        <div class="w3-col l4 12">
          <h3>About</h3>
          <h6>
            Our hotel is one of a kind. It is truely amazing. Lorem ipsum dolor
            sit amet, consectetur adipiscing elit, sed do eiusmod tempor
            incididunt ut labore et dolore magna aliqua. Ut enim ad minim
            veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex
            ea commodo consequat. Duis aute irure dolor in reprehenderit in
            voluptate velit esse cillum dolore eu fugiat nulla pariatur.
            Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
            officia deserunt mollit anim id est laborum consectetur adipiscing
            elit, sed do eiusmod tempor incididunt ut labore et dolore magna
            aliqua. Ut enim ad minim veniam.
          </h6>
          <p>
            We accept: <i class="fa fa-credit-card w3-large"></i>
            <i class="fa fa-cc-mastercard w3-large"></i>
            <i class="fa fa-cc-amex w3-large"></i>
            <i class="fa fa-cc-cc-visa w3-large"></i
            ><i class="fa fa-cc-paypal w3-large"></i>
          </p>
        </div>
        <div class="w3-col l8 12">
          <!-- Image of location/map -->
          <img
            src="${pageContext.request.contextPath}/images/carmoney.jpg"
            class="w3-image"
            style="width: 100%"
          />
        </div>
      </div>

      <div class="w3-row-padding w3-large w3-center" style="margin: 32px 0">
        <div class="w3-third">
          <i class="fa fa-map-marker w3-text-red"></i> 423 Some adr, Chicago, US
        </div>
        <div class="w3-third">
          <i class="fa fa-phone w3-text-red"></i> Phone: +00 151515
        </div>
        <div class="w3-third">
          <i class="fa fa-envelope w3-text-red"></i> Email: mail@mail.com
        </div>
      </div>

      <div class="w3-panel w3-red w3-leftbar w3-padding-32">
        <h6>
          <i class="fa fa-info w3-deep-orange w3-padding w3-margin-right"></i>
          On demand, we can offer playstation, babycall, children care, dog
          equipment, etc.
        </h6>
      </div>
      <div class="w3-container" id="contact">
        <h2>Contact</h2>
        <p>If you have any questions, do not hesitate to ask them.</p>
        <i class="fa fa-map-marker w3-text-red" style="width: 30px"></i>
        Chicago, US<br />
        <i class="fa fa-phone w3-text-red" style="width: 30px"></i> Phone: +00
        151515<br />
        <i class="fa fa-envelope w3-text-red" style="width: 30px"> </i> Email:
        mail@mail.com<br />
        <form action="/action_page.php" target="_blank">
          <p>
            <input
              class="w3-input w3-padding-16 w3-border"
              type="text"
              placeholder="Name"
              required
              name="Name"
            />
          </p>
          <p>
            <input
              class="w3-input w3-padding-16 w3-border"
              type="text"
              placeholder="Email"
              required
              name="Email"
            />
          </p>
          <p>
            <input
              class="w3-input w3-padding-16 w3-border"
              type="text"
              placeholder="Message"
              required
              name="Message"
            />
          </p>
          <p>
            <button class="w3-button w3-black w3-padding-large" type="submit">
              SEND MESSAGE
            </button>
          </p>
        </form>
      </div>

      <!-- End page content -->
    </div>

    <!-- Footer -->
    <footer class="w3-padding-32 w3-black w3-center w3-margin-top">
      <h5>Find Us On</h5>
      <div class="w3-xlarge w3-padding-16">
        <i class="fa fa-facebook-official w3-hover-opacity"></i>
        <i class="fa fa-instagram w3-hover-opacity"></i>
        <i class="fa fa-snapchat w3-hover-opacity"></i>
        <i class="fa fa-pinterest-p w3-hover-opacity"></i>
        <i class="fa fa-twitter w3-hover-opacity"></i>
        <i class="fa fa-linkedin w3-hover-opacity"></i>
      </div>
      <p>
        Powered by
        <a
          href="https://www.w3schools.com/w3css/default.asp"
          target="_blank"
          class="w3-hover-text-green"
          >Fernie Qin</a
        >
      </p>
    </footer>

    <!-- Modal -->
    <div
      class="modal fade"
      id="autoInsurancePlanUserRegistrationModal"
      tabindex="-1"
      role="dialog"
      aria-labelledby="autoInsurancePlanUserRegistrationModal"
      aria-hidden="true"
    >
      <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLongTitle">
              Provide Your Information
            </h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <input class="form-control" type="hidden" id="customerId" />
            Your Name:
            <input
              class="form-control"
              type="text"
              placeholder="Enter Name"
              id="customerName"
            />
            Your Age:
            <input
              class="form-control"
              type="number"
              placeholder="Enter Age"
              min="0"
              id="customerAge"
            />
            Your Gender:
            <select class="form-control" id="customerGender">
              <option selected>Select Your Gender</option>
              <option value="MALE">Male</option>
              <option value="FEMALE">Female</option>
              <option value="OTHER">Other</option>
            </select>
            Your Date of Birth:
            <input class="form-control" type="date" id="customerDOB" />
            Your Email:
            <input
              class="form-control"
              type="email"
              placeholder="Enter Email"
              id="customerEmail"
            />
            Your Mobile No:
            <input
              class="form-control"
              type="tel"
              placeholder="Enter Mobile No"
              id="customerMobile"
            />
            Your Address Line:
            <input
              class="form-control"
              type="text"
              placeholder="Enter Address Line"
              id="customerAddressLine"
            />
            Your City:
            <input
              class="form-control"
              type="text"
              placeholder="Enter City"
              id="customerCity"
            />
            Your State:
            <input
              class="form-control"
              type="text"
              placeholder="Enter State"
              id="customerState"
            />
            Your Country:
            <select class="form-control" id="customerCountry">
              <option selected>Select Your Country</option>
              <option value="United Kingdom">United Kingdom</option>
              <option value="France">France</option>
              <option value="Spain">Spain</option>
              <option value="Japan">Japan</option>
              <option value="South Korea">South Korea</option>
              <option value="China">China</option>
              <option value="United States">United States</option>
            </select>
            Your ZipCode:
            <input
              class="form-control"
              type="text"
              placeholder="Enter ZipCode"
              id="customerZipcode"
            />
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-dismiss="modal"
            >
              Close
            </button>
            <button type="button" class="btn btn-primary" id="autoInsurancePlanUserRegistrationSubmit">Submit</button>
          </div>
        </div>
      </div>
    </div>
    
  </body>
</html>
