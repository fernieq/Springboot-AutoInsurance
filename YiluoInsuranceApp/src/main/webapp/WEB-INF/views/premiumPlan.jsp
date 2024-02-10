<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Autoinsurance Standard Plan</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Raleway"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <link
      href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700|"
      rel="stylesheet"
      type="text/css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />

    <!-- Loading main css file -->
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/StandardPlanStyle.css"
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
        transition: transform 0.4s;
      }
      .plan-card:hover {
        transform: scale(1.1);
      }
      .info-card {
        margin: 0 auto;
        transition: transform 0.2s;
      }
      .info-card:hover {
        transform: scale(1.05);
      }
      .fadeinTitle {
        font-size: 140px;
        text-align: left;
        animation: fadein 5s infinite;
        -moz-animation: fadein 5s infinite; /* Firefox */
        -webkit-animation: fadein 5s infinite; /* Safari and Chrome */
        -o-animation: fadein 5s infinite; /* Opera */
      }
      .top-left {
        position: absolute;
        top: 80px;
        left: 16px;
      }
      header {
        position: relative;
        text-align: left;
        color: whitesmoke;
      }

      @keyframes fadein {
        from {
          opacity: 0;
        }
        to {
          opacity: 1;
        }
      }
      @-moz-keyframes fadein {
        /* Firefox */
        from {
          opacity: 0;
        }
        to {
          opacity: 1;
        }
      }
      @-webkit-keyframes fadein {
        /* Safari and Chrome */
        from {
          opacity: 0;
        }
        to {
          opacity: 1;
        }
      }
      @-o-keyframes fadein {
        /* Opera */
        from {
          opacity: 0;
        }
        to {
          opacity: 1;
        }
      }
      .btninfor {
        cursor: pointer;
        position: relative;
        padding: 10px 20px;
        background: white;
        border-top-right-radius: 10px;
        border-bottom-left-radius: 10px;
        transition: all 1s;
        &:after,
        &:before {
          content: " ";
          width: 10px;
          height: 10px;
          position: absolute;
          border: 0px solid #fff;
          transition: all 1s;
        }
        &:after {
          top: -1px;
          left: -1px;
          border-top: 5px solid black;
          border-left: 5px solid black;
        }
        &:before {
          bottom: -1px;
          right: -1px;
          border-bottom: 5px solid black;
          border-right: 5px solid black;
        }
        &:hover {
          border-top-right-radius: 0px;
          border-bottom-left-radius: 0px;
          /* background:rgba(0,0,0,.5);
          color:white; */
          &:before,
          &:after {
            width: 100%;
            height: 100%;
            /* border-color:white; */
          }
        }
      }

      .data-container-information {
        background: #e8e8e8;
        margin: 25px;
        display: flex;
        justify-content: center;
        align-items: center;
      }
      .button:hover {
        background-color: #555555;
        color: white;
      }
    </style>
  </head>
  <body class="w3-light-grey">
    <!-- Navigation Bar -->
    <div class="w3-bar w3-white w3-large">
      <a
        href="${pageContext.request.contextPath}/home"
        class="w3-bar-item w3-button w3-red w3-mobile"
        >Home</a
      >
      <a
        href="${pageContext.request.contextPath}/autoInsurancePlan"
        class="w3-bar-item w3-button w3-mobile"
        >Plans</a
      >
      <a href="#about" class="w3-bar-item w3-button w3-mobile">Highlights</a>
      <a href="#whatpeoplesay" class="w3-bar-item w3-button w3-mobile"
        >Reviews</a
      >
      <a
        href="#form"
        class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile"
        >Purchase the Plan</a
      >
    </div>
    <!-- Header -->
    <header
      class="w3-display-container w3-content"
      style="max-width: max-content"
    >
      <img
        class="w3-image"
        src="${pageContext.request.contextPath}/images/porsche-plan1.jpg"
        alt="The Car"
        style="min-width: 1000px"
        width="1500"
        height="800"
      />
      <div class="top-left">
        <p class="fadeinTitle">Take One Step</p>
        <p class="fadeinTitle">Above The World</p>
        <!-- <p class="fadeinTitle">Speed Limits</p> -->
      </div>
    </header>

    <main class="main-content">
      <div class="fullwidth-block">
        <div class="container" id="about">
          <h1>Highlights of Our Premium Plan:</h1>
        </br>
          <div class="row ingredient data-container-information btninfor info-card">
            <div class="col-md-4">
              <img
                src="${pageContext.request.contextPath}/images/standardplan-feature1.jpg"
                alt=""
              />
            </div>

            <div class="col-md-8">
              <h2>The Safety Concept</h2>
              <p>
                The Safety Concept To best protect our drivers and passengers,
                Mercedes-Benz has developed a comprehensive approach to
                automotive safety. These are the basic tenets: Equip drivers
                with the most up-to-date features to help prevent an accident
                Assist drivers in times of danger with features like Active
                Brake Assist® Protect drivers and passengers during an accident
                with coordinated sensors and restraint systems React properly
                with measures like automatic engine shut-off or unlocking doors,
                so the after-effects are mitigated.
              </p>
            </div>
          </div>
          <div class="row ingredient data-container-information btninfor info-card">
            <div class="col-md-4">
              <img
                src="${pageContext.request.contextPath}/images/standardplan-feature2.jpg"
                alt=""
              />
            </div>
            <div class="col-md-8">
              <h2>Certified Software Malfunction Support</h2>
              <p>
                To make sure every restoration is performed properly, all
                Certified Collision Centers employ trained technicians with
                advanced skills and experience. Our Workshop Information System
                (WIS) provides an extensive library of procedures, and the
                Xentry Diagnostic Unit is authorized by us for reprogramming,
                configuration, initialization, fault diagnosis and guided
                diagnostic tests.
              </p>
            </div>
          </div>
          <div class="row ingredient data-container-information btninfor info-card">
            <div class="col-md-4">
              <img
                src="${pageContext.request.contextPath}/images/standardplan-feature3.jpg"
                alt=""
              />
            </div>
            <div class="col-md-8">
              <h2>Xentry Portal</h2>
              <p>
                Crafted with superior quality down to the smallest detail,
                Mercedes-Benz Genuine Parts provide a guaranteed fit and finish
                and are backed by our Parts Limited Warranty. That includes
                wheels and tires, glass, headlamps, steering systems and more –
                all rigorously tested for quality and longevity.
              </p>
            </div>
          </div>
        </div>
      </div>
      <div class="fullwidth-block" data-bg-color="#EEE">
        <div class="container" id="whatpeoplesay">
          <h2 class="section-title">What Other Customers Say</h2>
          <div class="row">
            <div class="col-md-3 col-sm-6 plan-card">
              <div class="testimonial">
                <img src="images/person1.jpg" alt="" class="user-avatar" />
                <p>
                  Adipiscing elit, sed do eiusmod tempor incididunt ut labore
                  dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                  exercitation ullamco.
                </p>
                <cite>John Parias</cite>,<span class="title">Writer</span>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 plan-card">
              <div class="testimonial">
                <img src="images/person2.jpg" alt="" class="user-avatar" />
                <p>
                  Adipiscing elit, sed do eiusmod tempor incididunt ut labore
                  dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                  exercitation ullamco.
                </p>
                <cite>Sarah Dowson</cite>,<span class="title">Teacher</span>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 plan-card">
              <div class="testimonial">
                <img src="images/person3.jpg" alt="" class="user-avatar" />
                <p>
                  Adipiscing elit, sed do eiusmod tempor incididunt ut labore
                  dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                  exercitation ullamco.
                </p>
                <cite>Richard Marks</cite>,<span class="title">Athlete</span>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 plan-card">
              <div class="testimonial">
                <img src="images/person4.jpg" alt="" class="user-avatar" />
                <p>
                  Adipiscing elit, sed do eiusmod tempor incididunt ut labore
                  dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                  exercitation ullamco.
                </p>
                <cite>Susie Branson</cite>,<span class="title">Designer</span>
              </div>
            </div>
          </div>
          <!-- .row -->
        </div>
        <!-- .container -->
      </div>

      <div class="fullwidth-block cta">
        <div class="container">
          <form action="#" id="form">
            <div class="control">
              <input type="hidden" id="insurancePlanId" />
            </div>
            <h2 class="form-title">Purchase the Premium Plan</h2>
            <h3 class="form-title">$<b style="font-size: larger;">1999</b>/month &nbsp; plus $<b style="font-size: larger;">299</b> discount</h3>
            <div class="control">
              <input type="text" placeholder="Full Legal Name" />
              <i class="fa fa-user"></i>
            </div>
            <div class="control">
              <input type="text" placeholder="Email address..." />
              <i class="fa fa-envelope"></i>
            </div>
            <div class="control">
              <input type="text" placeholder="Phone number..." />
              <i class="fa fa-phone"></i>
            </div>
            <div class="select control">
              <select name="" id="insurancePlanCountry">
                <option value="#">Select Country</option>
                <option value="United Kingdom">United Kingdom</option>
                <option value="France">France</option>
                <option value="Spain">Spain</option>
                <option value="Japan">Japan</option>
                <option value="South Korea">South Korea</option>
                <option value="China">China</option>
                <option value="United States">United States</option>
              </select>
              <i class="fa fa-globe"></i>
            </div>
            <p>Choose Plan Start Date</p>
            <div class="control">
              <input type="date" id="insurancePlanStartDate"/>
              <i class="fa fa-calendar"></i> 
            </div>
            <p>Choose Plan End Date</p>
            <div class="control">
              <input type="date" id="insurancePlanEndDate"/>
              <i class="fa fa-calendar"></i>
            </div>
    
            <button type="button" class="btn btn-outline-secondary button" id="PremiumPlanPurchaseConfirmBtn">
              Ready To Pay
            </button>
          </form>
        </div>
      </div>
    </main>

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
    </footer>
  </body>
</html>
