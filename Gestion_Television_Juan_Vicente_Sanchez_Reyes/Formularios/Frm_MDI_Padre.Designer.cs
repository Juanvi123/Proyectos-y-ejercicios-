namespace Gestion_Television_Juan_Vicente_Sanchez_Reyes.Formularios
{
    partial class Frm_MDI_Padre
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_MDI_Padre));
            this.TS_Frm_Gestion_TV = new System.Windows.Forms.ToolStrip();
            this.TSB_Programacion = new System.Windows.Forms.ToolStripButton();
            this.TSB_Contenidos_Y_Eventos = new System.Windows.Forms.ToolStripButton();
            this.TSB_Mantenimiento_Usuarios = new System.Windows.Forms.ToolStripButton();
            this.TS_Frm_Gestion_TV.SuspendLayout();
            this.SuspendLayout();
            // 
            // TS_Frm_Gestion_TV
            // 
            this.TS_Frm_Gestion_TV.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.TSB_Programacion,
            this.TSB_Contenidos_Y_Eventos,
            this.TSB_Mantenimiento_Usuarios});
            this.TS_Frm_Gestion_TV.Location = new System.Drawing.Point(0, 0);
            this.TS_Frm_Gestion_TV.Name = "TS_Frm_Gestion_TV";
            this.TS_Frm_Gestion_TV.Size = new System.Drawing.Size(800, 25);
            this.TS_Frm_Gestion_TV.TabIndex = 0;
            this.TS_Frm_Gestion_TV.Text = "toolStrip1";
            // 
            // TSB_Programacion
            // 
            this.TSB_Programacion.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.TSB_Programacion.Font = new System.Drawing.Font("Lucida Console", 9F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TSB_Programacion.Image = ((System.Drawing.Image)(resources.GetObject("TSB_Programacion.Image")));
            this.TSB_Programacion.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.TSB_Programacion.Name = "TSB_Programacion";
            this.TSB_Programacion.Size = new System.Drawing.Size(105, 22);
            this.TSB_Programacion.Text = "Programación";
            // 
            // TSB_Contenidos_Y_Eventos
            // 
            this.TSB_Contenidos_Y_Eventos.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.TSB_Contenidos_Y_Eventos.Font = new System.Drawing.Font("Lucida Console", 9F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TSB_Contenidos_Y_Eventos.Image = ((System.Drawing.Image)(resources.GetObject("TSB_Contenidos_Y_Eventos.Image")));
            this.TSB_Contenidos_Y_Eventos.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.TSB_Contenidos_Y_Eventos.Name = "TSB_Contenidos_Y_Eventos";
            this.TSB_Contenidos_Y_Eventos.Size = new System.Drawing.Size(169, 22);
            this.TSB_Contenidos_Y_Eventos.Text = "Contenidos y Eventos";
            this.TSB_Contenidos_Y_Eventos.Click += new System.EventHandler(this.TSB_Contenidos_Y_Eventos_Click);
            // 
            // TSB_Mantenimiento_Usuarios
            // 
            this.TSB_Mantenimiento_Usuarios.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.TSB_Mantenimiento_Usuarios.Font = new System.Drawing.Font("Lucida Console", 9F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TSB_Mantenimiento_Usuarios.Image = ((System.Drawing.Image)(resources.GetObject("TSB_Mantenimiento_Usuarios.Image")));
            this.TSB_Mantenimiento_Usuarios.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.TSB_Mantenimiento_Usuarios.Name = "TSB_Mantenimiento_Usuarios";
            this.TSB_Mantenimiento_Usuarios.Size = new System.Drawing.Size(209, 22);
            this.TSB_Mantenimiento_Usuarios.Text = "Mantenimiento de Usuarios";
            this.TSB_Mantenimiento_Usuarios.Click += new System.EventHandler(this.TSB_Mantenimiento_Usuarios_Click);
            // 
            // Frm_MDI_Padre
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.TS_Frm_Gestion_TV);
            this.IsMdiContainer = true;
            this.Name = "Frm_MDI_Padre";
            this.Text = "Frm_MDI_Padre";
            this.TS_Frm_Gestion_TV.ResumeLayout(false);
            this.TS_Frm_Gestion_TV.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip TS_Frm_Gestion_TV;
        private System.Windows.Forms.ToolStripButton TSB_Programacion;
        private System.Windows.Forms.ToolStripButton TSB_Contenidos_Y_Eventos;
        private System.Windows.Forms.ToolStripButton TSB_Mantenimiento_Usuarios;
    }
}