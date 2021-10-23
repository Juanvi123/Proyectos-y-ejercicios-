using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Gestion_Television_Juan_Vicente_Sanchez_Reyes.Formularios
{
    public partial class Frm_MDI_Padre : Form
    {

        internal Frm_Contenidos_Eventos frm_Contenidos;
        internal Frm_Mantenimiento_Usuarios frm_Usuarios;

        private bool contidosEventos;
        private bool mantenimientoUsuarios;
        
        public Frm_MDI_Padre()
        {
            InitializeComponent();

            frm_Contenidos = new Frm_Contenidos_Eventos();
            frm_Contenidos.MdiParent = this;
            frm_Contenidos.Dock = DockStyle.Fill;

            frm_Usuarios = new Frm_Mantenimiento_Usuarios();
            frm_Usuarios.MdiParent = this;
            frm_Usuarios.Dock = DockStyle.Fill;

            contidosEventos = false;
            mantenimientoUsuarios = false;
        }

        private void TSB_Contenidos_Y_Eventos_Click(object sender, EventArgs e)
        {
            contidosEventos= true;
            mantenimientoUsuarios = false;
            if (contidosEventos)
            {
                frm_Contenidos.Show();
                frm_Usuarios.Hide();
                contidosEventos = false;
            }

        }

        private void TSB_Mantenimiento_Usuarios_Click(object sender, EventArgs e)
        {
            contidosEventos = false;
            mantenimientoUsuarios = true;
            if (mantenimientoUsuarios)
            {
                frm_Usuarios.Show();
                frm_Contenidos.Hide();
                mantenimientoUsuarios = false;
            }
        }
    }
}
