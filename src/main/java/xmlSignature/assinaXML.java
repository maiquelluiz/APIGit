package xmlSignature;

import Certificados.OBJKeyStoreA1;
import Apoio.SystemExceptions;
import java.io.*;
import java.nio.charset.Charset;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.*;
import javax.swing.JOptionPane;
import javax.xml.XMLConstants;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.*;
import javax.xml.crypto.dsig.spec.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Maiquel
 */
public class assinaXML {

    public String assina(String xml, String literal, String chave) throws SystemExceptions.CertificadoException, SystemExceptions.DBeException {

        try {
            //System.out.println(xml);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = (Document) factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.trim().getBytes("UTF8")));
            Node rootElement;
            doc.getDocumentElement().removeAttribute("xmlns:ns2");

            //System.out.println("AQUIIII-->" + doc.getFirstChild().getNodeName());
            if (doc.getFirstChild().getNodeName().equalsIgnoreCase("CTe")) {
                NodeList elements = doc.getElementsByTagName("infCte");
                rootElement = elements.item(0).getParentNode();
                org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(0);
                String ide = el.getAttribute("Id");
                el.setIdAttribute("Id", true);
            } else if (doc.getFirstChild().getNodeName().equalsIgnoreCase("CTeOS")) {
                NodeList elements = doc.getElementsByTagName("infCte");
                rootElement = elements.item(0).getParentNode();
                org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(0);
                String ide = el.getAttribute("Id");
                el.setIdAttribute("Id", true);
            } else if (doc.getFirstChild().getNodeName().equalsIgnoreCase("enviMDFe")) {
                NodeList elements = doc.getElementsByTagName("infMDFe");
                rootElement = elements.item(0).getParentNode();
                org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(0);
                String ide = el.getAttribute("Id");
                el.setIdAttribute("Id", true);
            } else if (doc.getFirstChild().getNodeName().equalsIgnoreCase("eventoCTe")) {
                NodeList elements = doc.getElementsByTagName("infEvento");
                rootElement = elements.item(0).getParentNode();
                org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(0);
                String ide = el.getAttribute("Id");
                el.setIdAttribute("Id", true);
            } else if (doc.getFirstChild().getNodeName().equalsIgnoreCase("eventoMDFe")) {
                NodeList elements = doc.getElementsByTagName("infEvento");
                rootElement = elements.item(0).getParentNode();
                org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(0);
                String ide = el.getAttribute("Id");
                el.setIdAttribute("Id", true);
            } else {
                NodeList elements = doc.getElementsByTagName("infCanc");
                rootElement = elements.item(0).getParentNode();
                org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(0);
                String ide = el.getAttribute("Id");
                el.setIdAttribute("Id", true);
            }

            //doc.getDocumentElement().setIdAttribute("ID", true);
            //NodeList elements = doc.getElementsByTagName("infCte");
            //Node element = doc.getDocumentElement().getFirstChild().getNextSibling();
            // elements.getLength();
            //Element el = (Element) element;
            // Element el = doc.getDocumentElement().getFirstChild().getChildNodes();
            //String id = el.getAttribute("Id");       
            String id = literal + chave;

            //Cria o arquivo XML
            //Document docs = builder.parse(new File("c:/xml/"+doc.getDocumentElement+"-CTe.xml"));
            // Create a DOM XMLSignatureFactory that will be used to
            // generate the enveloped signature.
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

            // Create a Reference to the enveloped document (in this case,
            // you are signing the whole document, so a URI of "" signifies
            // that, and also specify the SHA1 digest algorithm and
            // the ENVELOPED Transform.
            ArrayList transformList = new ArrayList();
            TransformParameterSpec tps = null;
            Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, tps);

            Transform c14NTransform = fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

            transformList.add(envelopedTransform);
            transformList.add(c14NTransform);

            // Load the KeyStore and get the signing key and certificate.
            KeyStore ks = OBJKeyStoreA1.getInstance().getKeyStore();

            KeyStore.PrivateKeyEntry pkEntry = null;

            Enumeration aliasesEnum = ks.aliases();

            PrivateKey privateKey = null;
            while (aliasesEnum.hasMoreElements()) {
                String alias = (String) aliasesEnum.nextElement();
                if (ks.isKeyEntry(alias)) {
                    pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection(OBJKeyStoreA1.getInstance().getSenha().toCharArray()));

                    privateKey = pkEntry.getPrivateKey();
                    break;
                }
            }

            X509Certificate cert = (X509Certificate) pkEntry.getCertificate();

            // Create the KeyInfo containing the X509Data.
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            // x509Content.add(cert.getSubjectX500Principal().getName());
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

            // doc.getDocumentElement().removeAttribute("xmlns:ns2");
            // ((Element)
            // doc.getDocumentElement().getElementsByTagName("NFe").item(0))
            // .setAttribute("xmlns", "http://www.portalfiscal.inf.br/nfe");
            // Create a DOM XMLSignatureFactory that will be used to
            // generate the enveloped signature.
            Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                    DigestMethod.SHA1, null), transformList, null, null);

            // Create the SignedInfo.
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
                    fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

            // Create the XMLSignature, but don't sign it yet.
            XMLSignature signature = fac.newXMLSignature(si, ki);

            // Marshal, generate, and sign the enveloped signature.
            // Create a DOMSignContext and specify the RSA PrivateKey and
            // location of the resulting XMLSignature's parent element.
            //doc.setIdAttribute("ID", true);
            DOMSignContext dsc = new DOMSignContext(privateKey, rootElement);
            signature.sign(dsc);

            // Output the resulting document.
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();

            trans.setOutputProperty(OutputKeys.INDENT, "no");
            trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty(OutputKeys.MEDIA_TYPE, "text/xml");
            trans.setOutputProperty(OutputKeys.METHOD, "xml");
            trans.transform(new DOMSource(doc), new StreamResult(os));

            return new String(os.toByteArray(), Charset.forName("UTF-8")).trim();

        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException
                | KeyStoreException | UnrecoverableEntryException | MarshalException | XMLSignatureException
                | TransformerException ex) {
            throw new SystemExceptions.CertificadoException(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            throw new SystemExceptions.CertificadoException(ex.getMessage());
        } catch (SAXException ex) {
            throw new SystemExceptions.CertificadoException(ex.getMessage());
        } catch (IOException ex) {
            throw new SystemExceptions.CertificadoException(ex.getMessage());
        }
    }

    public String assinarCancCTe(String xml) throws SystemExceptions.CertificadoException, SystemExceptions.DBeException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Document docs = builder.parse(new File(
            // "c:/xml/430802017886010001735500000000010000030371-nfe.xml"));
            Document doc = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));

            // Create a DOM XMLSignatureFactory that will be used to
            // generate the enveloped signature.
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

            // Create a Reference to the enveloped document (in this case,
            // you are signing the whole document, so a URI of "" signifies
            // that, and also specify the SHA1 digest algorithm and
            // the ENVELOPED Transform.
            ArrayList transformList = new ArrayList();
            TransformParameterSpec tps = null;
            Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, tps);
            Transform c14NTransform = fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

            transformList.add(envelopedTransform);
            transformList.add(c14NTransform);

            /*
        // Load the KeyStore and get the signing key and certificate.

        String configName = CONST.token;
        Provider p = new sun.security.pkcs11.SunPKCS11(configName);
        Security.addProvider(p);
        String pin = CONST.senha;
        KeyStore ks = KeyStore.getInstance("pkcs11", p);
        ks.load(null, pin.toCharArray());
             */
            KeyStore ks = OBJKeyStoreA1.getInstance().getKeyStore();

            KeyStore.PrivateKeyEntry pkEntry = null;
            Enumeration aliasesEnum = ks.aliases();
            PrivateKey privateKey = null;
            while (aliasesEnum.hasMoreElements()) {
                String alias = (String) aliasesEnum.nextElement();
                if (ks.isKeyEntry(alias)) {
                    pkEntry = (KeyStore.PrivateKeyEntry) ks
                            .getEntry(alias, new KeyStore.PasswordProtection(OBJKeyStoreA1.getInstance().getSenha().toCharArray()));
                    privateKey = pkEntry.getPrivateKey();
                    break;
                }
            }

            X509Certificate cert = (X509Certificate) pkEntry.getCertificate();

            // Create the KeyInfo containing the X509Data.
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            // x509Content.add(cert.getSubjectX500Principal().getName());
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

            for (int i = 0; i < doc.getDocumentElement().getElementsByTagName("CTe").getLength(); i++) {
                assinar(fac, transformList, privateKey, ki, doc, i);
            }
            // Output the resulting document.
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(os));

            return os.toString();
        } catch (TransformerException | NoSuchAlgorithmException | UnrecoverableEntryException | 
                KeyStoreException | InvalidAlgorithmParameterException | SAXException |
                IOException | ParserConfigurationException ex) {
            throw new SystemExceptions.CertificadoException(ex.getMessage());
        }
    }

    private void assinar(XMLSignatureFactory fac, ArrayList transformList, PrivateKey privateKey, KeyInfo ki, Document doc, int i) {

        // Obtem elemento do documento a ser assinado, será criado uma
        // REFERENCE para o mesmo
        NodeList elements = doc.getElementsByTagName("infCTe");
        Element el = (Element) elements.item(i);
        String id = el.getAttribute("Id");

        // doc.getDocumentElement().removeAttribute("xmlns:ns2");
        // ((Element)
        // doc.getDocumentElement().getElementsByTagName("NFe").item(0))
        // .setAttribute("xmlns", "http://www.portalfiscal.inf.br/nfe");
        // Create a DOM XMLSignatureFactory that will be used to
        // generate the enveloped signature.
        Reference ref = null;
        try {
            ref = fac.newReference("#" + id, fac.newDigestMethod(
                    DigestMethod.SHA1, null), transformList, null, null);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Erro 336: " + ex, "Erro NoSuchAlgorithmException", JOptionPane.ERROR_MESSAGE);
        } catch (InvalidAlgorithmParameterException ex) {
            JOptionPane.showMessageDialog(null, "Erro 338: " + ex, "Erro InvalidAlgorithmParameterException", JOptionPane.ERROR_MESSAGE);
        }

        // Create the SignedInfo.
        SignedInfo si = null;
        try {
            si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null), fac
                            .newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "assinaXML Erro 350: " + ex, "Erro NoSuchAlgorithmException", JOptionPane.ERROR_MESSAGE);
        } catch (InvalidAlgorithmParameterException ex) {
            JOptionPane.showMessageDialog(null, "assinaXML Erro 352: " + ex, "Erro InvalidAlgorithmParameterException", JOptionPane.ERROR_MESSAGE);
        }

        // Create the XMLSignature, but don't sign it yet.
        XMLSignature signature = fac.newXMLSignature(si, ki);

        // Marshal, generate, and sign the enveloped signature.
        // Create a DOMSignContext and specify the RSA PrivateKey and
        // location of the resulting XMLSignature's parent element.
        DOMSignContext dsc = new DOMSignContext(privateKey, doc
                .getDocumentElement().getElementsByTagName("CTe").item(i));
        try {
            signature.sign(dsc);
        } catch (MarshalException ex) {
            JOptionPane.showMessageDialog(null, "assinaXML Erro 366: " + ex, "Erro MarshalException", JOptionPane.ERROR_MESSAGE);
        } catch (XMLSignatureException ex) {
            JOptionPane.showMessageDialog(null, "assinaXML Erro 368: " + ex, "Erro XMLSignatureException", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ValidateXml(String xml, String xsd) {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            // Create a SchemaFactory capable of understanding WXS schemas.
            SchemaFactory factory2 = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Load a WXS schema, represented by a Schema instance.
            Source schemaFile = new StreamSource(new File(xsd));
            Schema schema = factory2.newSchema(schemaFile);

            // Create a Validator object, which can be used to validate
            // an instance document.
            Validator validator = schema.newValidator();

            // Validate the DOM tree.
            validator.validate(new DOMSource(document));

        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(null, "assinaXML Erro 395: " + ex, "Erro ParserConfigurationException", JOptionPane.ERROR_MESSAGE);
        } catch (SAXException ex) {
            JOptionPane.showMessageDialog(null, "assinaXML Erro 397: " + ex, "Erro SAXException", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "assinaXML Erro 399: " + ex, "Erro IOException", JOptionPane.ERROR_MESSAGE);
        }
    }
}
