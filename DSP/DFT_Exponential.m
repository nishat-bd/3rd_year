function dft_demo()
    N = 8;          
    fs = 8000;      
    f1 = 1000;      
    f2 = 2000;      
    ts=1/fs;
    ind=1;  
    x =zeros(1,N);
for n = 1:N
    m = n-1;
    x(ind) = sin(2*pi*f1*m*ts)+0.5*sin(2*pi*f2*m*ts+(3*pi/4));
    ind=ind+1; 
end
    t = 1:N;
    X = dft(x, N);
    X_real = real(X);
    X_imag = imag(X);
    X_mag = sqrt(X_real.^2 + X_imag.^2);
    X_phase_radians = atan2(X_imag, X_real);
    
    phase_thresholds = [0, -30, 30, -45, 45, -60, 60, -90, 90];
    X_phase_radians(~ismembertol(X_phase_radians, deg2rad(phase_thresholds), 1e-6)) = 0;
 
    X_phase_degrees = rad2deg(X_phase_radians);
 
    figure('Name','Time Domain Signal')
    plot(t, x,'o','LineStyle','--','Color','red');
    grid minor;
    title('Time Domain Signal');
    xlabel('Time (Millisecond)');
    ylabel('Amplitude');
 
     % Plot the DFT magnitude
    figure('Name','Magnitude Part')
    stem(0:N-1, X_mag,'LineStyle','-.',...
     'MarkerSize',12,'Marker','s',...
     'MarkerFaceColor','red',...
     'MarkerEdgeColor','black',...
     'LineWidth',3,...
     'Color','black');
    grid minor;
    title('Magnitude part of X_exp(m)');
    xlabel('m (KHz)');
    ylabel('Magnitude'); 
 
    % Plot the real part of the DFT coefficients
    figure('Name','Real Part')
    stem(0:N-1, X_real,'LineStyle','-.',...
   'MarkerSize',12,'Marker','s',...
    'MarkerFaceColor','blue',...
    'MarkerEdgeColor','green',...
    'LineWidth',3,'Color','black')
    grid minor;
    title('Real part of X_exp(m)')
    xlabel('m (KHz)')
    ylabel('Amplitude');
 
    % Plot the imaginary part of the DFT coefficients
    figure('Name','Imaginary Part')
    stem(0:N-1, X_imag,'LineStyle','-.',...
     'MarkerSize',12,'Marker','s',...
     'MarkerFaceColor','black',...
     'MarkerEdgeColor','green','LineWidth',3,'Color','black')
    grid minor;
    title('Imaginary part of X_exp(m)')
    xlabel('m (KHz)')
    ylabel('Amplitude')
 
    % Plot the phase angle of the DFT coefficients in degrees
    figure('Name','Phase of Angle')
    stem(0:N-1, X_phase_radians,'LineStyle','-.',...
     'MarkerSize',12,'Marker','s',...
     'MarkerFaceColor','magenta',...
     'MarkerEdgeColor','green','LineWidth',3,'Color','black')
    grid minor;
    title('Phase Angle of X_exp(m)')
    xlabel('m (KHz)')
    ylabel('Degree');
end
 
function X = dft(x, N)
    X = zeros(1, N);
    for k = 0:N-1
        X(k+1) = 0;
        for n = 0:N-1
            X(k+1) = X(k+1) + x(n+1) * exp(-1i * 2 * pi * k * n / N);
        end
    end
end


