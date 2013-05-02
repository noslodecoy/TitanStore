<html>
  <head>
    <meta name="layout" content="main">

  </head>
  <body>
    <div>
      <h1>Your Cart</h1>
      <table>
      <g:each in="${cartItemList?}">
        <tr>
          <td><g:link controller="album" action="view" id="${it.storeItem?.id}">${it.title}</g:link></td>
          <td>${it.price}</td>
          <td><g:link controller="cart" action="remove" params="[cartItem: it.id]">Remove from cart</g:link></td>
        </tr>
        <span class="tag"></span>
        <span class="tag"></span>

      </g:each>
      </table>
    </div>
  </body>
</html