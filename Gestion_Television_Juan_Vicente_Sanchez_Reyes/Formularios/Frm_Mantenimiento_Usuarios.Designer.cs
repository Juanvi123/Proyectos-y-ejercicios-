namespace Gestion_Television_Juan_Vicente_Sanchez_Reyes.Formularios
{
    partial class Frm_Mantenimiento_Usuarios
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
            this.GB_Buscar = new System.Windows.Forms.GroupBox();
            this.CMB_Login = new System.Windows.Forms.ComboBox();
            this.Lbl_Login = new System.Windows.Forms.Label();
            this.GB_Datos_Usuario = new System.Windows.Forms.GroupBox();
            this.Lbl_login_Seleccionado = new System.Windows.Forms.Label();
            this.Lbl_Apellido = new System.Windows.Forms.Label();
            this.Lbl_Nombre = new System.Windows.Forms.Label();
            this.Lbl_Password = new System.Windows.Forms.Label();
            this.CB_Estado = new System.Windows.Forms.CheckBox();
            this.Txt_Login = new System.Windows.Forms.TextBox();
            this.Txt_Nombre = new System.Windows.Forms.TextBox();
            this.Txt_Apellido = new System.Windows.Forms.TextBox();
            this.Txt_Password = new System.Windows.Forms.TextBox();
            this.Btn_Nuevo = new System.Windows.Forms.Button();
            this.Btn_Guardar = new System.Windows.Forms.Button();
            this.Btn_Cancelar = new System.Windows.Forms.Button();
            this.Btn_Borrar = new System.Windows.Forms.Button();
            this.GB_Buscar.SuspendLayout();
            this.GB_Datos_Usuario.SuspendLayout();
            this.SuspendLayout();
            // 
            // GB_Buscar
            // 
            this.GB_Buscar.Controls.Add(this.Lbl_Login);
            this.GB_Buscar.Controls.Add(this.CMB_Login);
            this.GB_Buscar.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.GB_Buscar.Location = new System.Drawing.Point(33, 41);
            this.GB_Buscar.Name = "GB_Buscar";
            this.GB_Buscar.Size = new System.Drawing.Size(725, 100);
            this.GB_Buscar.TabIndex = 0;
            this.GB_Buscar.TabStop = false;
            this.GB_Buscar.Text = "Buscar";
            // 
            // CMB_Login
            // 
            this.CMB_Login.FormattingEnabled = true;
            this.CMB_Login.Location = new System.Drawing.Point(189, 42);
            this.CMB_Login.Name = "CMB_Login";
            this.CMB_Login.Size = new System.Drawing.Size(484, 23);
            this.CMB_Login.TabIndex = 0;
            // 
            // Lbl_Login
            // 
            this.Lbl_Login.AutoSize = true;
            this.Lbl_Login.Location = new System.Drawing.Point(94, 45);
            this.Lbl_Login.Name = "Lbl_Login";
            this.Lbl_Login.Size = new System.Drawing.Size(43, 15);
            this.Lbl_Login.TabIndex = 1;
            this.Lbl_Login.Text = "Login";
            // 
            // GB_Datos_Usuario
            // 
            this.GB_Datos_Usuario.Controls.Add(this.Txt_Password);
            this.GB_Datos_Usuario.Controls.Add(this.Txt_Apellido);
            this.GB_Datos_Usuario.Controls.Add(this.Txt_Nombre);
            this.GB_Datos_Usuario.Controls.Add(this.Txt_Login);
            this.GB_Datos_Usuario.Controls.Add(this.CB_Estado);
            this.GB_Datos_Usuario.Controls.Add(this.Lbl_Password);
            this.GB_Datos_Usuario.Controls.Add(this.Lbl_Nombre);
            this.GB_Datos_Usuario.Controls.Add(this.Lbl_Apellido);
            this.GB_Datos_Usuario.Controls.Add(this.Lbl_login_Seleccionado);
            this.GB_Datos_Usuario.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.GB_Datos_Usuario.Location = new System.Drawing.Point(33, 181);
            this.GB_Datos_Usuario.Name = "GB_Datos_Usuario";
            this.GB_Datos_Usuario.Size = new System.Drawing.Size(725, 207);
            this.GB_Datos_Usuario.TabIndex = 1;
            this.GB_Datos_Usuario.TabStop = false;
            this.GB_Datos_Usuario.Text = "Datos del Usuario";
            // 
            // Lbl_login_Seleccionado
            // 
            this.Lbl_login_Seleccionado.AutoSize = true;
            this.Lbl_login_Seleccionado.Location = new System.Drawing.Point(26, 41);
            this.Lbl_login_Seleccionado.Name = "Lbl_login_Seleccionado";
            this.Lbl_login_Seleccionado.Size = new System.Drawing.Size(43, 15);
            this.Lbl_login_Seleccionado.TabIndex = 0;
            this.Lbl_login_Seleccionado.Text = "Login";
            // 
            // Lbl_Apellido
            // 
            this.Lbl_Apellido.AutoSize = true;
            this.Lbl_Apellido.Location = new System.Drawing.Point(26, 153);
            this.Lbl_Apellido.Name = "Lbl_Apellido";
            this.Lbl_Apellido.Size = new System.Drawing.Size(59, 15);
            this.Lbl_Apellido.TabIndex = 1;
            this.Lbl_Apellido.Text = "Apellido";
            // 
            // Lbl_Nombre
            // 
            this.Lbl_Nombre.AutoSize = true;
            this.Lbl_Nombre.Location = new System.Drawing.Point(26, 96);
            this.Lbl_Nombre.Name = "Lbl_Nombre";
            this.Lbl_Nombre.Size = new System.Drawing.Size(58, 15);
            this.Lbl_Nombre.TabIndex = 2;
            this.Lbl_Nombre.Text = "Nombre";
            // 
            // Lbl_Password
            // 
            this.Lbl_Password.AutoSize = true;
            this.Lbl_Password.Location = new System.Drawing.Point(425, 41);
            this.Lbl_Password.Name = "Lbl_Password";
            this.Lbl_Password.Size = new System.Drawing.Size(69, 15);
            this.Lbl_Password.TabIndex = 3;
            this.Lbl_Password.Text = "Password";
            // 
            // CB_Estado
            // 
            this.CB_Estado.AutoSize = true;
            this.CB_Estado.Location = new System.Drawing.Point(541, 92);
            this.CB_Estado.Name = "CB_Estado";
            this.CB_Estado.Size = new System.Drawing.Size(70, 19);
            this.CB_Estado.TabIndex = 5;
            this.CB_Estado.Text = "Estado";
            this.CB_Estado.UseVisualStyleBackColor = true;
            // 
            // Txt_Login
            // 
            this.Txt_Login.Location = new System.Drawing.Point(97, 41);
            this.Txt_Login.Name = "Txt_Login";
            this.Txt_Login.Size = new System.Drawing.Size(305, 21);
            this.Txt_Login.TabIndex = 6;
            // 
            // Txt_Nombre
            // 
            this.Txt_Nombre.Location = new System.Drawing.Point(97, 96);
            this.Txt_Nombre.Name = "Txt_Nombre";
            this.Txt_Nombre.Size = new System.Drawing.Size(305, 21);
            this.Txt_Nombre.TabIndex = 7;
            // 
            // Txt_Apellido
            // 
            this.Txt_Apellido.Location = new System.Drawing.Point(97, 150);
            this.Txt_Apellido.Name = "Txt_Apellido";
            this.Txt_Apellido.Size = new System.Drawing.Size(602, 21);
            this.Txt_Apellido.TabIndex = 8;
            // 
            // Txt_Password
            // 
            this.Txt_Password.Location = new System.Drawing.Point(521, 41);
            this.Txt_Password.Name = "Txt_Password";
            this.Txt_Password.Size = new System.Drawing.Size(178, 21);
            this.Txt_Password.TabIndex = 9;
            // 
            // Btn_Nuevo
            // 
            this.Btn_Nuevo.Location = new System.Drawing.Point(33, 433);
            this.Btn_Nuevo.Name = "Btn_Nuevo";
            this.Btn_Nuevo.Size = new System.Drawing.Size(75, 23);
            this.Btn_Nuevo.TabIndex = 2;
            this.Btn_Nuevo.Text = "Nuevo";
            this.Btn_Nuevo.UseVisualStyleBackColor = true;
            // 
            // Btn_Guardar
            // 
            this.Btn_Guardar.Location = new System.Drawing.Point(461, 433);
            this.Btn_Guardar.Name = "Btn_Guardar";
            this.Btn_Guardar.Size = new System.Drawing.Size(75, 23);
            this.Btn_Guardar.TabIndex = 3;
            this.Btn_Guardar.Text = "Guardar";
            this.Btn_Guardar.UseVisualStyleBackColor = true;
            // 
            // Btn_Cancelar
            // 
            this.Btn_Cancelar.Location = new System.Drawing.Point(683, 433);
            this.Btn_Cancelar.Name = "Btn_Cancelar";
            this.Btn_Cancelar.Size = new System.Drawing.Size(75, 23);
            this.Btn_Cancelar.TabIndex = 4;
            this.Btn_Cancelar.Text = "Cancelar";
            this.Btn_Cancelar.UseVisualStyleBackColor = true;
            // 
            // Btn_Borrar
            // 
            this.Btn_Borrar.Location = new System.Drawing.Point(247, 433);
            this.Btn_Borrar.Name = "Btn_Borrar";
            this.Btn_Borrar.Size = new System.Drawing.Size(75, 23);
            this.Btn_Borrar.TabIndex = 5;
            this.Btn_Borrar.Text = "Borrar";
            this.Btn_Borrar.UseVisualStyleBackColor = true;
            // 
            // Frm_Mantenimiento_Usuarios
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 524);
            this.Controls.Add(this.Btn_Borrar);
            this.Controls.Add(this.Btn_Cancelar);
            this.Controls.Add(this.Btn_Guardar);
            this.Controls.Add(this.Btn_Nuevo);
            this.Controls.Add(this.GB_Datos_Usuario);
            this.Controls.Add(this.GB_Buscar);
            this.Name = "Frm_Mantenimiento_Usuarios";
            this.Text = "Frm_Mantenimiento_Usuarios";
            this.GB_Buscar.ResumeLayout(false);
            this.GB_Buscar.PerformLayout();
            this.GB_Datos_Usuario.ResumeLayout(false);
            this.GB_Datos_Usuario.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox GB_Buscar;
        private System.Windows.Forms.Label Lbl_Login;
        private System.Windows.Forms.ComboBox CMB_Login;
        private System.Windows.Forms.GroupBox GB_Datos_Usuario;
        private System.Windows.Forms.TextBox Txt_Password;
        private System.Windows.Forms.TextBox Txt_Apellido;
        private System.Windows.Forms.TextBox Txt_Nombre;
        private System.Windows.Forms.TextBox Txt_Login;
        private System.Windows.Forms.CheckBox CB_Estado;
        private System.Windows.Forms.Label Lbl_Password;
        private System.Windows.Forms.Label Lbl_Nombre;
        private System.Windows.Forms.Label Lbl_Apellido;
        private System.Windows.Forms.Label Lbl_login_Seleccionado;
        private System.Windows.Forms.Button Btn_Nuevo;
        private System.Windows.Forms.Button Btn_Guardar;
        private System.Windows.Forms.Button Btn_Cancelar;
        private System.Windows.Forms.Button Btn_Borrar;
    }
}