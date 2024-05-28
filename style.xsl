<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Product List</title>
                <style>
                    body {
                    font-family: Arial, sans-serif;
                    }
                    .data {
                    display: block;
                    margin: 10px;
                    padding: 10px;
                    border: 1px solid #000;
                    }
                    .data div {
                    margin: 5px 0;
                    }
                </style>
            </head>
            <body>
                <h1>Product List</h1>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="data">
        <div class="data">
            <div class="product_id">Product ID: <xsl:value-of select="product_id"/></div>
            <div class="product_name">Product Name: <xsl:value-of select="product_name"/></div>
            <div class="description">Description: <xsl:value-of select="description"/></div>
            <div class="price">Price: <xsl:value-of select="price"/></div>
        </div>
    </xsl:template>
</xsl:stylesheet>
