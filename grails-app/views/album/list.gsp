<html>
  <head>
    <meta name="layout" content="main">

  </head>
  <body>
    <div>
      <g:each in="${album?}">

        <span class="tag">${it.title}</span>
        <span class="tag">${it.price}</span>
        <g:link controller="cart" action="add" params="[album:${it.id}]">Add to cart</g:link>

      </g:each>
    </div>
  </body>
</html