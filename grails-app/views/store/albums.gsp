<html>
  <head>
    <meta name="layout" content="main">

  </head>
  <body>
    <div>
      <h1>Albums:</h1>
      <table>
      <g:each in="${albumList?}">
        <tr>
          <td>${it.title}</td>
          <td>${it.price}</td>
          <td><g:link controller="cart" action="add" params="[album: it.id]">Add to cart</g:link></td>
        </tr>
        <span class="tag"></span>
        <span class="tag"></span>

      </g:each>
      </table>
    </div>
  </body>
</html