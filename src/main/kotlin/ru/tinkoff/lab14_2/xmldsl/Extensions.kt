package ru.tinkoff.lab14_2.xmldsl

fun objectXML(block: ObjectXML.() -> Unit) : ObjectXML {
    val result = ObjectXML()
    result.block()
    return result
}

fun ObjectXML.addresses(block: XMLArrayBuilder.() -> Unit) {
    val xmlArrayBuilder = XMLArrayBuilder()
    xmlArrayBuilder.block()
    this.addresses = xmlArrayBuilder.toArray()
}

