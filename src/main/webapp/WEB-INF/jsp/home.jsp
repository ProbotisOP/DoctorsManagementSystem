<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="ISO-8859-1">
      <title>My Team</title>
    </head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <body>
      <center>
        <h1 style="align-items: center;"> MY TEAM</h1>

      </center>

      <br>

      <center>
        <div class="card" style="width: 18rem;">

          <div class="card-body">
            <h5 class="card-title">MEMBERS</h5>
            <a href="/team" class="btn btn-primary">Show Members </a>
          </div>
        </div>
      </center>
      <br>
      <center>
        <div class="card" style="width: 18rem;">

          <div class="card-body">
            <h5 class="card-title">DOCTORS LIST</h5>
            <a href="/showDoc" class="btn btn-primary">Show All </a>
          </div>
        </div>
      </center>
      <br>
      <br>

      <center>
        <form method="POST" action="/showdocbyid">

          Select Doctor By ID :
          <select id="doctor" name="docid" class="dropdown">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
          </select>
          <input type="submit">


        </form>
      </center>




    </body>

    </html>