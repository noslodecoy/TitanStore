<html>
  <head>
    <title><g:layoutTitle default="TitanTunes" /></title>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}" />
    <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <g:layoutHead />
  <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'titantunes.css')}" type="text/css" media="screen" charset="utf-8">
  <g:javascript library="scriptaculous" />			
  <g:javascript library="application" />	

</head>
<body>
  <div id="spinner" class="spinner" style="display:none;">
    <img src="${createLinkTo(dir:'images',file:'spinner.gif')}" alt="Spinner" />
  </div>	



  <div class="logo">
    <g:link controller="store"><img src="${createLinkTo(dir:'images',file:'titantunes.png')}" alt="TitanTunes" /></g:link>
  </div>

  <div id="loginBox" class="loginBox">
    <g:if test="${session?.user}">
      <div style="margin-top:20px">
        <div style="float:right;">
          <a href="#">Profile</a> | <g:link controller="user" action="logout">Logout</g:link><br>						
        </div>
        Welcome back <span id="userFirstName">${session?.user?.firstName}!</span><br><br>
        You have purchased (${session.user.purchasedSongs?.size() ?: 0}) songs.<br>
        <li><g:link controller="user" action="music">My Music</g:link></li>
      </div>
    </g:if>
    <g:else>

      <g:form 
        name="loginForm" 
        url="[controller:'user',action:'login']">
        <div class="loginFields">
          <div>
            Username:
            <g:textField name="login" value="${fieldValue(bean:loginCmd, field:'login')}" id="username" class="loginField"></g:textField>
          </div>
          <div>
            Password:
            <g:passwordField name="password" id="password" class="loginField"></g:passwordField>			
          </div>
          <input 	type="submit" name="loginButton" id="loginButton" />
        </div>
        <div id="registerPane">
          Need an account? <g:link controller="user" action="register">Signup now</g:link>
        </div>	
      </g:form>
      <g:renderErrors bean="${loginCmd}"></g:renderErrors>

    </g:else>
  </div>


  <div id="page">
    <div id="content">
      <div id="navPane">
        <h3>Browse:</h3>
        <ul class="menu">
          <li><a href="#">Alternative</a></li>
          <li><a href="#">Classical</a></li>
          <li><a href="#">Hip-Hop</a></li>
          <li><a href="#">Indie</a></li>
          <li><a href="#">Rock</a></li>
        </ul>
      </div>

      <div id="main">
        <g:layoutBody />					
      </div>
    </div>
    <br style="clear: both;" />

  </div>

    <div id="footer">
      &copy; 2013 TitanTunes International Entertainment Holding Group, LLC.
    </div>

</body>	
</html>