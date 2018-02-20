package sistema;

import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import java.awt.Color;
import javax.media.j3d.Appearance;
import javax.media.j3d.LineStripArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;


public class Planeta extends Sphere {

    public static final int ESCALA = 1;
    
    /**
     *  crear un nuevo planeta
     *
     * @param radio El radio del planeta,
     */
    public Planeta(String textura, float radio) {
        super(radio / ESCALA, Primitive.GENERATE_NORMALS
                | Primitive.GENERATE_TEXTURE_COORDS, 50, null);
        
        Appearance apariencia = new Appearance();
        TextureLoader tex = new TextureLoader(textura, null);
        apariencia.setTexture(tex.getTexture());
        setAppearance(apariencia);

    }
   
    /**
     * Para agregarle un satéite a nuestro planeta
     *
     * 
     */
    public void agregaSatelite(TraslacionPlaneta traslacionSatelite) {
        super.addChild(traslacionSatelite);
    }
}
