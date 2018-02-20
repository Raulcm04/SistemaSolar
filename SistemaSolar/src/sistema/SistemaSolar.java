package sistema;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import javax.media.j3d.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

/**
 * 
 * @author soul
 */
public class SistemaSolar  extends Applet{

     BranchGroup group = new BranchGroup();

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
        @Override
        public void init()
{
    //*****************************//universo
        super.init();
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        add("Center",canvas);   
        SimpleUniverse universe = new SimpleUniverse(canvas);
        universe.addBranchGraph(group);       
        this.atras(universe);
        this.vista(universe, canvas);
       // this.luz(universe);

}
    public SistemaSolar() {
       
        Planeta Sol = new Planeta("src/img/sol.jpg", 0.12f);
        RotacionPlaneta rotacionSol = new RotacionPlaneta(Sol, RotacionPlaneta.GIRO_NORMAL);
        
    


  //*****************************MERCURIO
        Planeta Mercurio = new Planeta("src/img/mercurio.jpg", 0.01f);
        RotacionPlaneta rotacionMercurio = new RotacionPlaneta(Mercurio, RotacionPlaneta.GIRO_LENTO);
        DistanciaPlanetas distanciaMercurio = new DistanciaPlanetas(rotacionMercurio, 0.2f);
         group.addChild(distanciaMercurio.curvas(0, 0.2f));
   
        TraslacionPlaneta traslacionMercurio = new TraslacionPlaneta(distanciaMercurio, TraslacionPlaneta.GIRO_UNO+3999);
        
        Sol.agregaSatelite(traslacionMercurio);
      
        
   //*****************************VENUS
        Planeta Venus = new Planeta("src/img/venus.jpg", 0.028f);
        RotacionPlaneta rotacionVenus = new RotacionPlaneta(Venus, RotacionPlaneta.GIRO_NORMAL);
        DistanciaPlanetas distanciaVenus = new DistanciaPlanetas(rotacionVenus, 0.33f);
         group.addChild(distanciaVenus.curvas(0, 0.33f));
   
        TraslacionPlaneta traslacionVenus = new TraslacionPlaneta(distanciaVenus, TraslacionPlaneta.GIRO_UNO+6211);

        Sol.agregaSatelite(traslacionVenus);
       
  //*****************************TIERRA
        //Creamos un nuevo planeta, con la textura de la tierra:
        Planeta tierra = new Planeta("src/img/tierra.jpg", 0.03f);

        //  Le asignamos una velocidad de rotación
        RotacionPlaneta rotacionTierra = new RotacionPlaneta(tierra, RotacionPlaneta.GIRO_RAPIDO);

        //  Le asignamos una distancia a la rotación
        DistanciaPlanetas distanciaTierra = new DistanciaPlanetas(rotacionTierra, 0.53f);
        group.addChild(distanciaTierra.curvas(0, 0.53f));
  
        //  Le asignamos una traslación a la distancia, que en sí es una rotación
        TraslacionPlaneta traslacionTierra = new TraslacionPlaneta(distanciaTierra, TraslacionPlaneta.GIRO_UNO+8087);
        Sol.agregaSatelite(traslacionTierra);
      
  //*****************************LUNA
        Planeta luna = new Planeta("src/img/luna.jpg", 0.01f);
        RotacionPlaneta rotacionLuna = new RotacionPlaneta(luna, RotacionPlaneta.GIRO_RAPIDO);
        DistanciaPlanetas distanciaLuna = new DistanciaPlanetas(rotacionLuna, 0.068f);
        TraslacionPlaneta traslacionLuna = new TraslacionPlaneta(distanciaLuna, TraslacionPlaneta.GIRO_NORMAL);
        tierra.agregaSatelite(traslacionLuna);
   
        //  Agregamos la traslación como hija del sol. Con esto tenemos
       
  
  //*****************************MARTE
        Planeta marte = new Planeta("src/img/marte.jpg", 0.023f);
        RotacionPlaneta rotacionMarte = new RotacionPlaneta(marte, RotacionPlaneta.GIRO_RAPIDO + RotacionPlaneta.GIRO_RAPIDO);
        DistanciaPlanetas distanciaMarte = new DistanciaPlanetas(rotacionMarte, 0.68f);
        group.addChild(distanciaMarte.curvas(0, 0.68f));
        TraslacionPlaneta traslacionMarte = new TraslacionPlaneta(distanciaMarte, TraslacionPlaneta.GIRO_UNO+10604);
        Sol.agregaSatelite(traslacionMarte);
        group.addChild(rotacionSol);
        
  //*****************************JUPITER
  
        Planeta jupiter = new Planeta("src/img/jupiter.jpg", 0.030f);
        RotacionPlaneta rotacionJupiter = new RotacionPlaneta(jupiter, RotacionPlaneta.GIRO_RAPIDO + RotacionPlaneta.GIRO_RAPIDO);
        DistanciaPlanetas distanciaJupiter = new DistanciaPlanetas(rotacionJupiter, 0.79f);
        group.addChild(distanciaJupiter.curvas(0, 0.79f));
        TraslacionPlaneta traslacionJupiter = new TraslacionPlaneta(distanciaJupiter, TraslacionPlaneta.GIRO_UNO+19087);
        Sol.agregaSatelite(traslacionJupiter);
        
  
  
  //*****************************SATURNO
        Planeta saturno = new Planeta("src/img/saturno.jpg", 0.035f);
        RotacionPlaneta rotacionSaturno = new RotacionPlaneta(saturno, RotacionPlaneta.GIRO_RAPIDO + RotacionPlaneta.GIRO_RAPIDO);
        DistanciaPlanetas distanciaSaturno = new DistanciaPlanetas(rotacionSaturno, 0.89f);
        group.addChild(distanciaSaturno.curvas(0, 0.89f));
        TraslacionPlaneta traslacionSaturno = new TraslacionPlaneta(distanciaSaturno, TraslacionPlaneta.GIRO_UNO+34356);
        Sol.agregaSatelite(traslacionSaturno);
        
  
  
  
  //*****************************URANO
  Planeta urano = new Planeta("src/img/urano.jpeg", 0.025f);
        RotacionPlaneta rotacionUrano = new RotacionPlaneta(urano, RotacionPlaneta.GIRO_RAPIDO + RotacionPlaneta.GIRO_RAPIDO);
        DistanciaPlanetas distanciaUrano = new DistanciaPlanetas(rotacionUrano, 0.99f);
        group.addChild(distanciaUrano.curvas(0, 0.99f));
        TraslacionPlaneta traslacionUrano = new TraslacionPlaneta(distanciaUrano, TraslacionPlaneta.GIRO_UNO+54970);
        Sol.agregaSatelite(traslacionUrano);
        
  
  
  
  //*****************************NEPTUNO
  
        Planeta neptuno = new Planeta("src/img/neptuno.jpg", 0.030f);
        RotacionPlaneta rotacionNeptuno = new RotacionPlaneta(neptuno, RotacionPlaneta.GIRO_RAPIDO + RotacionPlaneta.GIRO_RAPIDO);
        DistanciaPlanetas distanciaNeptuno = new DistanciaPlanetas(rotacionNeptuno, 1.10f);
        group.addChild(distanciaJupiter.curvas(0, 1.10f));
        TraslacionPlaneta traslacionNeptuno = new TraslacionPlaneta(distanciaNeptuno, TraslacionPlaneta.GIRO_UNO+98947);
        Sol.agregaSatelite(traslacionNeptuno);
        

        
        
    }
    
    
     
public void luz(SimpleUniverse su) {

        BranchGroup bgLight = new BranchGroup();

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), Double.MAX_VALUE);
        Color3f lightColour1 = new Color3f(1.0f, 1.0f, 1.0f);
        Vector3f lightDir1 = new Vector3f(-1.0f, 0.0f, -0.5f);
        DirectionalLight light1 = new DirectionalLight(lightColour1, lightDir1);
        light1.setInfluencingBounds(bounds);

        Vector3f lightDir2 = new Vector3f(1.0f, 0.0f, 0.5f);
        DirectionalLight light2 = new DirectionalLight(lightColour1, lightDir2);
        light2.setInfluencingBounds(bounds);

        bgLight.addChild(light1);
        bgLight.addChild(light2);

        su.addBranchGraph(bgLight);
    }
        
    //////////FONDO
    
    private Node Background(String imagen)
    {
        TextureLoader cargar= new TextureLoader(imagen,this);
        Background fondo= new Background(cargar.getImage());
        fondo.setApplicationBounds(bounds);     
        return fondo;  
    }
    public void atras(SimpleUniverse universo){
        BranchGroup root = new BranchGroup();
        
        root.addChild(Background("src/img/fondo.jpg"));
        root.compile();
        universo.addBranchGraph(root);
    }
  // FONDO  ///////////////////
    
    public void vista(SimpleUniverse universo, Canvas3D c)
    {
        //la mas utilizada es la orbital
        OrbitBehavior ob = new OrbitBehavior(); //ya tengo la vista
        BoundingSphere bounds = new BoundingSphere(new Point3d(0, 0, 0), Double.MAX_VALUE); //ya tengo a que se le va a aplicar esa vista
        ob.setSchedulingBounds(bounds);
        universo.getViewingPlatform().setViewPlatformBehavior(ob);//enviasr el behavior (la forma de observar)
        
        
    }

    public static void main(String[] args) {
      new MainFrame(new SistemaSolar(),1500,1000);
    }

}
